package com.cn.tju.service;

import com.cn.tju.pojo.Role;

import java.util.List;

public interface RoleService {

	List<Role> selectRolesByUserId(int userId);
	
}