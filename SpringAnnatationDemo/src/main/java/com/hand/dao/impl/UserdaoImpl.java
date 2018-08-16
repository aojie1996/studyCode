package com.hand.dao.impl;

import com.hand.dao.UserDAO;
import com.hand.entity.User;
import com.hand.entity.UserMapper;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class UserdaoImpl implements UserDAO {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }
    @Override
    public void insertByJdbcTemlate(User user) {
        String sql = "insert into User values(?,?,?,?)";
        jdbcTemplateObject.update(sql,user.getId(),user.getUserName(),user.getUserAge(),user.getUserAddress());
        System.out.println("成功插入一条消息");
    }

    @Override
    public User findByIdByJdbcTemlate(int id) {
        User user = new User();
        String sql = "select id,username,userAge,userAddress from user where id=?";
        user = jdbcTemplateObject.queryForObject(sql,new Object[]{id},new UserMapper());
        return user;
    }

    @Override
    public List<User> findAll() {
        String sql ="select id,username,userAge,userAddress from user";
        List<User> list = new ArrayList<>();
        list = jdbcTemplateObject.query(sql,new BeanPropertyRowMapper<User>(User.class));
        return list;
    }

    @Override
    public int updateUser(User user) {
        int i=0;
        String sql ="update user set username=?,userAge=?,userAddress=? where id=?";
        i=jdbcTemplateObject.update(sql,
                user.getUserName(),user.getUserAge(),user.getUserAddress(),user.getId());
        return i;
    }

    @Override
    public int deleteUser(int id) {
        int flag=0;
         String sql="delete from user where id=?";
         flag=jdbcTemplateObject.update(sql,id);
         return flag;
    }


}
