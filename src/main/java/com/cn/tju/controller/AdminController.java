package com.cn.tju.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;


@Slf4j
@Controller
public class AdminController {

    @RequestMapping(value = "/main/admin/index", method = RequestMethod.GET)
    public String admin(HttpServletRequest request, Model model) {
        log.info("admin");
        return "admin/index";
    }

    @RequestMapping(value = "/main/user/index", method = RequestMethod.GET)
    public String user(HttpServletRequest request, Model model) {
        log.info("user");
        return "admin/indexuser";
    }

    @RequestMapping(value = "/admin/user_manage", method = RequestMethod.GET)
    public String user_manage(HttpServletRequest request, Model model) {
        log.info("用户管理");
        return "admin/user_manage";
    }
}
