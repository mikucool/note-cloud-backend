package com.hzz.notecloudbackend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzz.notecloudbackend.model.dto.LoginDTO;
import com.hzz.notecloudbackend.model.dto.RegisterDTO;
import com.hzz.notecloudbackend.model.entity.User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

public interface UserService extends IService<User> {
    User executeRegister(RegisterDTO dto);

    String executeLogin(LoginDTO dto, HttpSession session);
}
