package com.cn.tju.service;

import com.cn.tju.pojo.User;

public interface UserService {  	

	User user(User user);
	
	User selectLogin(String username);

	User getUserById(int i);

	User selectByPrimaryKey(int i);
	
	User getUserByusername(String username);
	
	int inster(User user);
	
	Boolean getLoginUser(User user);

}  
