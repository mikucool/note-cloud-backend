package com.hzz.notecloudbackend.model.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * ＤＴＯ　用于接收封装客户端的数据，此　ＤＴＯ　用于接收客户端的注册信息
 */
@Data
public class RegisterDTO {

    @NotEmpty(message = "输入用户名")
    @Length(min = 2, max = 15, message = "长度在2-15")
    private String username;

    @NotEmpty(message = "请输入密码")
    @Length(min = 6, max = 20, message = "长度在6-20")
    private String password;

    @NotEmpty(message = "请再次输入密码")
    @Length(min = 6, max = 20, message = "长度在6-20")
    private String checkPassword;

    @NotEmpty(message = "请输入电子邮箱")
    @Email(message = "邮箱格式不正确")
    private String email;
}