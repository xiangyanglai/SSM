package com.cn.tju.pojo;

import lombok.Data;

@Data
public class User {
	private int id;
	private String username;
	private String password;
	private int age;
	private Integer access;

}
