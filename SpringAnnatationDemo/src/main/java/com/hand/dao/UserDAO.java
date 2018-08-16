package com.hand.dao;

import com.hand.entity.User;

import java.util.List;

public interface UserDAO {
    void insertByJdbcTemlate(User user);//添加一条用户数据
    User findByIdByJdbcTemlate(int id);//根据ID查询客户信息
    List<User> findAll();//查找所有用户信息
    int updateUser(User user);//修改用户信息
    int deleteUser(int id);//删除用户信息
}
