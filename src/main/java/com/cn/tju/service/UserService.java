package com.cn.tju.service;

import com.cn.tju.pojo.User;
import com.cn.tju.util.ResultDO;

import java.util.List;

public interface UserService {  	

	User selectLogin(String username);

	User getUserById(int i);

	User selectByPrimaryKey(int i);
	
	User getUserByusername(String username);
	

	Boolean getLoginUser(User user);

	public ResultDO<List<User>> selectAllUserList();

	public ResultDO<Boolean> insertNewUser(User newUser);


}  
