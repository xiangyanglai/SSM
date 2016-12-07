package com.cn.tju.controller;


import com.alibaba.fastjson.JSON;
import com.cn.tju.pojo.AmmeterSetting;
import com.cn.tju.pojo.User;
import com.cn.tju.service.UserService;
import com.cn.tju.service.impl.AmmeterSettingServiceImpl;
import com.cn.tju.util.EncryptionUtil;
import com.cn.tju.util.ResultDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;


@Slf4j
@Controller
public class AdminController {

    @Resource
    UserService userServiceImpl;

    @Resource
    AmmeterSettingServiceImpl ammeterSettingServiceImpl;

    @RequestMapping(value = "/main/admin/index", method = RequestMethod.GET)
    public String admin(HttpServletRequest request, Model model) {
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
        ResultDO<List<User>> listResultDO = userServiceImpl.selectAllUserList();
        ResultDO<List<AmmeterSetting>> ammeterSettingList = ammeterSettingServiceImpl.selectAllAmmeterSettingList();
        if (listResultDO.isSuccess())
        {
            model.addAttribute("queryUserResult",true);
            model.addAttribute("userList",listResultDO.getModule());
        }else {
            model.addAttribute("queryUserResult",false);
        }

        if (ammeterSettingList.isSuccess())
        {
            model.addAttribute("queryAmmeterSettingResult",true);
            model.addAttribute("ammeterSettingList",ammeterSettingList.getModule());
        }else {
            model.addAttribute("queryAmmeterSettingResult",false);
        }

        return "admin/user_manage";
    }


    @RequestMapping(value = "/system/alarm", method = RequestMethod.GET)
    public String alarm(HttpServletRequest request, Model model) {
        log.info("系统预警");
        return "admin/alarm";
    }

    @RequestMapping(value = "/admin/insertUser")

    @ResponseBody
    public String insertUser(HttpServletRequest request, @RequestBody User user, Model model) {
        try{
            user.setUserPwd(EncryptionUtil.getHash(user.getUserPwd(),"MD5"));
            user.setDatetime(new Date());
            return JSON.toJSONString(userServiceImpl.insertNewUser(user));
        }catch (Exception e)
        {
            log.error("删除新用户失败，params：{}",user.toString());
        }
        ResultDO<Boolean> booleanResultDO = new ResultDO<>();
        return JSON.toJSONString(booleanResultDO);
    }

}
