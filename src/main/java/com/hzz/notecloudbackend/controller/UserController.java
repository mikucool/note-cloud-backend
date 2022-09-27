package com.hzz.notecloudbackend.controller;

import com.hzz.notecloudbackend.common.api.ApiResult;
import com.hzz.notecloudbackend.model.dto.LoginDTO;
import com.hzz.notecloudbackend.model.dto.RegisterDTO;
import com.hzz.notecloudbackend.model.entity.User;
import com.hzz.notecloudbackend.service.UserService;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
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
    private ApiResult<String> login(@Valid @RequestBody LoginDTO dto, HttpSession session) {
        String token = userService.executeLogin(dto, session);
        if (ObjectUtils.isEmpty(token)) {
            return ApiResult.failed("error password");
        }
        return ApiResult.success(token);
    }

    @RequestMapping("/logout")
    private ApiResult<String> logout(@RequestParam String token, HttpSession session) {
        System.out.println(session.getAttribute(token));
        if (!ObjectUtils.isEmpty(session.getAttribute(token))) {
            session.removeAttribute(token);
        }
        return ApiResult.success("logout successfully");
    }

    @RequestMapping("/test")
    public ApiResult<Object> test(@RequestParam String token, HttpSession session) {
        System.out.println(token);
        System.out.println(session.getAttribute(token));
        return ApiResult.success("test");
    }
}
