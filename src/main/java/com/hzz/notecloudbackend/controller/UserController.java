package com.hzz.notecloudbackend.controller;

import com.hzz.notecloudbackend.common.api.ApiResult;
import com.hzz.notecloudbackend.model.dto.LoginDTO;
import com.hzz.notecloudbackend.model.dto.RegisterDTO;
import com.hzz.notecloudbackend.model.entity.User;
import com.hzz.notecloudbackend.service.UserService;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("/note-cloud/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    private ApiResult<String> register(@Valid @RequestBody RegisterDTO dto) {
        User user = userService.executeRegister(dto);
        if (ObjectUtils.isEmpty(user)) {
            return ApiResult.failed("register Failed");
        }
        return ApiResult.success("register successfully");
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    private ApiResult<String> login(@Valid @RequestBody LoginDTO dto) {
        return ApiResult.success("login successfully");
    }

    @RequestMapping("/test")
    public ApiResult<Object> test() {
        User user = new User();
        user.setPassword("1234");
        return ApiResult.success(user);
    }
}
