package com.zoo9.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zoo9.seckill.pojo.User;
import com.zoo9.seckill.utils.vo.LoginVo;
import com.zoo9.seckill.utils.vo.RespBean;

public interface IUserService extends IService<User> {
    RespBean doLogin(LoginVo loginVo);
}
