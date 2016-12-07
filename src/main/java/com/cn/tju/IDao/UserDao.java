package com.cn.tju.IDao;

import com.cn.tju.pojo.User;

import java.util.List;

public interface UserDao {
    User selectId(int id);

    User selectLogin(String username);

    List<User> selectAllUser();

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}