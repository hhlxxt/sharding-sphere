package com.zoro.sharding.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "t_user")  //指定对应表
public class User {

    @TableField(value = "uid")
    private Long userId;

    @TableField(value = "uname")
    private String username;

    private String ustatus;
}
