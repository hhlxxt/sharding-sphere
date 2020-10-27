package com.zoro.sharding.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zoro.sharding.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {
}
