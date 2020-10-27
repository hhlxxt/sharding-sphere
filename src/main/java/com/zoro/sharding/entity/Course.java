package com.zoro.sharding.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class Course {
    private Long cid;
    private String cname;
    @TableField(value = "userId")
    private Long userId;
    private String cstatus;
}
