package com.cn.tju.service.impl;

import com.cn.tju.IDao.RoleDao;
import com.cn.tju.IDao.UserDao;
import com.cn.tju.pojo.Role;
import com.cn.tju.pojo.User;
import com.cn.tju.service.RoleService;
import com.cn.tju.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("roleServiceImpl")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;


    public List<Role> selectRolesByUserId(int userId) {
        return roleDao.selectRolesByUserId(userId);
    }
}

