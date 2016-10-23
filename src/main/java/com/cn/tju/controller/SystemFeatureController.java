package com.cn.tju.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;


@Slf4j
@Controller
@RequestMapping("/system")
public class SystemFeatureController {

    @RequestMapping(value = "/comming", method = RequestMethod.GET)
    public String lcd(HttpServletRequest request, Model model) {
        log.info("lcd");
        return "admin/comming";
    }
}
