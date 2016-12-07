package com.cn.tju.controller;

import com.cn.tju.util.JsonConverterUtil;
import com.google.code.kaptcha.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by search on 2016/11/16.
 */
@Slf4j
@Controller
@RequestMapping("/system")
public class UserLoginController {

    @Autowired
    private AuthenticationManager myAuthenticationManager;

    @RequestMapping(value="/login",method= RequestMethod.POST)
    @ResponseBody
    public String login(@RequestParam(defaultValue="") String username,
                      @RequestParam(defaultValue="") String password,
                      @RequestParam(defaultValue="") String verifyCode,
                      HttpServletRequest request)
    {

        HttpSession session = request.getSession();
        String code = (String)session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
        //首先校验验证码
        if(!verifyCode.equals(code))
        {
            return JsonConverterUtil.loginInfoByJson("验证码输入错误，请重试！",false);
        }


        username = username.trim();
        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);
        try {
            Authentication authentication = myAuthenticationManager.authenticate(authRequest); //调用loadUserByUsername
            SecurityContextHolder.getContext().setAuthentication(authentication);
            session.setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext()); // 这个非常重要，否则验证后将无法登陆
            return JsonConverterUtil.loginInfoByJson(authentication.getName(),true);
        } catch (AuthenticationException ex) {
            return JsonConverterUtil.loginInfoByJson("用户密码或者密码错误",false);
        }
    }
}
