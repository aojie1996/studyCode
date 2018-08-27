package com.hand.service.impl;

import com.hand.dao.UserDAO;
import com.hand.entity.User;
import com.hand.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @ProjectName ssmDemo
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author aojie
 * @Date 2018/8/17 14:20
 * @Version 1.0
 **/


@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserDAO userdao;

    public User selectUserById(int id) {
        User user = userdao.selectUserById(id);
        return user;
    }
}
