package com.hand.dao.impl;

import com.hand.dao.EmailDAO;
import com.hand.event.MailSendEvent;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.sql.DataSource;

public class EmailDAOImpl extends JdbcDaoSupport implements EmailDAO {
    @Override
    public void addEmail(MailSendEvent mailSendEvent) {
        String sql = "insert into Email values(?,?,?)";
        JdbcTemplate jdbcTemplate = new JdbcTemplate((BasicDataSource) mailSendEvent.getObject());
        jdbcTemplate.update(sql,mailSendEvent.getTheme(),
                mailSendEvent.getText(), mailSendEvent.getReceiver());
//        this.getJdbcTemplate().update(sql,mailSendEvent.getTheme(),
//                mailSendEvent.getText(), mailSendEvent.getReceiver());
        System.out.println("添加一行邮件信息");
    }

}
