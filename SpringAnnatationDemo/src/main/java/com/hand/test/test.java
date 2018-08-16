package com.hand.test;

import com.hand.entity.User;
import com.hand.service.UserService;
import com.hand.service.impl.UserServiceImpl;
import com.hand.util.ApplicationContextUtil;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class test {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入id：");
        int id=scanner.nextInt();
        System.out.println("请输入姓名");
        String userName=scanner.next();
        System.out.println("请输入年龄");
        String userAge=scanner.next();
        System.out.println("请输入地址");
        String userAddress=scanner.next();
        ApplicationContext applicationContext=ApplicationContextUtil.getApplicationContext();
        BasicDataSource basicDataSource= (BasicDataSource) applicationContext.getBean("dataSource");
        User user = new User(id,userName,userAge,userAddress,basicDataSource);
        UserService userService= new UserServiceImpl();
        userService.addUser(user);
    }
}
