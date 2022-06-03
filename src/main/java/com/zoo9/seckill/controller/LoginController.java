package com.zoo9.seckill.controller;

import com.zoo9.seckill.service.IUserService;
import com.zoo9.seckill.utils.vo.LoginVo;
import com.zoo9.seckill.utils.vo.RespBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Controller
@RequestMapping("/login")
@Slf4j  //lomlok的日志注解
public class LoginController {
    @Autowired
    IUserService userService;
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }
    @RequestMapping("/doLogin")
    @ResponseBody
    public RespBean doLogin(@Valid LoginVo loginVo){
        return userService.doLogin(loginVo);
    }
}
