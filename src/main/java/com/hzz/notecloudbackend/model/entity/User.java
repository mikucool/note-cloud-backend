package com.hzz.notecloudbackend.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Builder
@Accessors
@NoArgsConstructor
@AllArgsConstructor
@TableName("note_user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    @TableField("username")
    private String username;

//    @JsonIgnore() 不返回该属性给前端
    @JsonIgnore()
    @TableField("password")
    private String password;

    @TableField("email")
    private String email;

    @Builder.Default
    @TableField("avatar")
    private String avatar = "https://s3.ax1x.com/2020/12/01/DfHNo4.jpg";
}
