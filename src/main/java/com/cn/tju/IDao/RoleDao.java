package com.cn.tju.IDao;

import com.cn.tju.pojo.Role;
import com.cn.tju.pojo.User;

import java.util.List;

public interface RoleDao {

    List<Role> selectRolesByUserId(int userId);

}