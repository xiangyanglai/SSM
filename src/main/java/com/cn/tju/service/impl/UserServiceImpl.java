package com.cn.tju.service.impl;

import com.cn.tju.pojo.WeatherLog;
import com.cn.tju.util.Constants;
import com.cn.tju.util.ResultDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tju.IDao.UserDao;
import com.cn.tju.pojo.User;
import com.cn.tju.service.UserService;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Slf4j
@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public User getUserById(int id) {
        // TODO Auto-generated method stub
        System.out.println(id + this.userDao.selectId(id).getUserName());

        return this.userDao.selectId(id);
    }


    public Boolean getLoginUser(User userLogin) {
        // TODO Auto-generated method stub
        if (userLogin.getUserName().equals("") || (userLogin.getUserPwd().equals(""))) {
            return false;
        } else {
            User user = new User();
            if (this.userDao.selectLogin(userLogin.getUserName()) != null) {
                user = userDao.selectLogin(userLogin.getUserName());
                if (user.toString().equals("")) {

                    return false;
                } else {

                    if (user.getUserPwd().equals(userLogin.getUserPwd())) {
                        return true;
                    } else {
                        return false;
                    }
                }
            } else {
                return false;
            }
        }
    }

    public ResultDO<List<User>> selectAllUserList() {
        ResultDO<List<User>> resultDO = new ResultDO<List<User>>();
        try
        {
            List<User> weatherLogs = userDao.selectAllUser();
            resultDO.setModule(weatherLogs);
            resultDO.setSuccess(true);
        }catch (Throwable e)
        {
            log.error("query all user info  filed.",e);
            resultDO.setErrorCode(Constants.getErrCode(Constants.ERR_DB_EXCEPTION,Constants.DEFAULT_ERROR_MESSAGE));
        }
        return resultDO;
    }

    @Override
    public ResultDO<Boolean> insertNewUser(User newUser) {
        ResultDO<Boolean> resultDO = new ResultDO<Boolean>();
        try
        {
            int result = userDao.insert(newUser);
            resultDO.setSuccess(true);
        }catch (Throwable e)
        {
            log.error("query all user info  filed.",e);
            resultDO.setErrorCode(Constants.getErrCode(Constants.ERR_DB_EXCEPTION,Constants.DEFAULT_ERROR_MESSAGE));
        }
        return resultDO;
    }

    public User selectLogin(String username) {
        // TODO Auto-generated method stub
        return this.userDao.selectLogin(username);
    }


    public User selectByPrimaryKey(int i) {
        // TODO Auto-generated method stub
        return this.userDao.selectByPrimaryKey(i);
    }


    public User getUserByusername(String username) {
        // TODO Auto-generated method stub
        return this.userDao.selectLogin(username);
    }


    public int inster(User user) {
        // TODO Auto-generated method stub
        int i = this.userDao.insert(user);
        return i;
    }


}

