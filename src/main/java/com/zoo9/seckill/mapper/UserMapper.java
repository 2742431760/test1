package com.zoo9.seckill.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zoo9.seckill.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
