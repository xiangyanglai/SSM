package com.cn.tju.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;


@Slf4j
@Controller
@RequestMapping("/user")
public class UserFeatureController {

    @RequestMapping(value = "/lcd", method = RequestMethod.GET)
    public String lcd(HttpServletRequest request, Model model) {
        log.info("lcd");
        return "admin/lcd";
    }

    @RequestMapping(value = "/energy", method = RequestMethod.GET)
    public String energy(HttpServletRequest request, Model model) {
        log.info("energy");
        return "admin/energy";
    }

    @RequestMapping(value = "/circle", method = RequestMethod.GET)
    public String circle(HttpServletRequest request, Model model) {
        log.info("circle");
        return "admin/circle";
    }

    @RequestMapping(value = "/data_nh", method = RequestMethod.GET)
    public String data(HttpServletRequest request, Model model) {
        log.info("data");
        return "admin/data_cmp";
    }
    
    @RequestMapping(value = "/data_nx", method = RequestMethod.GET)
    public String data_cmp(HttpServletRequest request, Model model) {
        log.info("data");
        return "admin/data";
    }

    @RequestMapping(value = "/nxtj", method = RequestMethod.GET)
    public String nxtj(HttpServletRequest request, Model model) {
        log.info("nxtj");
        return "admin/nxtj";
    }

    @RequestMapping(value = "/inroom", method = RequestMethod.GET)
    public String inroom(HttpServletRequest request, Model model) {
        log.info("inroom");
        return "admin/inroom";
    }

    @RequestMapping(value = "/machine", method = RequestMethod.GET)
    public String machine(HttpServletRequest request, Model model) {
        log.info("machine");
        return "admin/machine";
    }

    @RequestMapping(value = "/userInfo")
    public String userInfo(HttpServletRequest request, Model model) {
        log.info("machine");
        return "user/user_info";
    }

    @RequestMapping(value = "/lockScreen")
    public String lockScreen(HttpServletRequest request, Model model) {
        log.info("machine");
        return "user/user_lock";
    }

}
