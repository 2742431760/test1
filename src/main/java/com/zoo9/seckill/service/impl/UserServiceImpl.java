package com.zoo9.seckill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zoo9.seckill.mapper.UserMapper;
import com.zoo9.seckill.pojo.User;
import com.zoo9.seckill.service.IUserService;
import com.zoo9.seckill.utils.MD5Util;
import com.zoo9.seckill.utils.ValidatorUtil;
import com.zoo9.seckill.utils.vo.LoginVo;
import com.zoo9.seckill.utils.vo.RespBean;
import com.zoo9.seckill.utils.vo.RespBeanEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public RespBean doLogin(LoginVo loginVo) {
        String mobile = loginVo.getMobile();
        String password = loginVo.getPassword();
        if (StringUtils.isEmpty(mobile) || StringUtils.isEmpty(password)) {
            return RespBean.error(RespBeanEnum.LOGIN_ERROR);
        }
        if (!ValidatorUtil.isMobile(mobile)) {
            return RespBean.error(RespBeanEnum.MOBILE_ERROR);
        }
        User user = userMapper.selectById(mobile);
        if(null==user){
            return RespBean.error(RespBeanEnum.LOGIN_ERROR);
        }
        if (!MD5Util.formPassToDBPass(password, user.getSlat()).equals(user.getPassword())) {
            return RespBean.error((RespBeanEnum.LOGIN_ERROR));
        }
        return null;
    }
}
