package com.hand.service.impl;

import com.hand.entity.User;
import com.hand.service.UserService;
import com.hand.util.ApplicationContextUtil;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;


public class UserServiceImpl extends JdbcDaoSupport implements UserService {


    @Override
    public void addUser(User user) {
        String sql = "insert into User values(?,?,?,?)";
        JdbcTemplate jdbcTemplate=new JdbcTemplate(user.getBasicDataSource());
        jdbcTemplate.update(sql,user.getId(),user.getUserName(),user.getUserAge(),user.getUserAddress());
        System.out.println("成功插入一条消息");
    }

}
