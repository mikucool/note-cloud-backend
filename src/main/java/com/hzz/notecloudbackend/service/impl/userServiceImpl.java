package com.hzz.notecloudbackend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzz.notecloudbackend.common.exception.ApiAsserts;
import com.hzz.notecloudbackend.mapper.UserMapper;
import com.hzz.notecloudbackend.model.dto.RegisterDTO;
import com.hzz.notecloudbackend.model.entity.User;
import com.hzz.notecloudbackend.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class userServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Override
    public User executeRegister(RegisterDTO dto) {
        //查询是否有相同用户名的用户
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername, dto.getUsername()).or().eq(User::getEmail, dto.getEmail());
        User user = baseMapper.selectOne(wrapper);
        if (!ObjectUtils.isEmpty(user)) {
            ApiAsserts.fail("账号或邮箱已存在！");
        }
        // 构造一个用户，利用了 @Builder 简化了构造方法和 set 方法
        User addUser = User.builder()
                .username(dto.getUsername())
                .password(dto.getPassword())
                .email(dto.getEmail())
                .build();
        baseMapper.insert(addUser);

        return addUser;
    }
}
