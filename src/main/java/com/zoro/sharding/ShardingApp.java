package com.zoro.sharding;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zoro
 * @version 1.0
 * @date 2020/10/27 20:11
 * @desc
 */

@SpringBootApplication
@MapperScan("com.zoro.sharding.mapper")
public class ShardingApp {
    public static void main(String[] args) {
        SpringApplication.run(ShardingApp.class, args);
    }
}
