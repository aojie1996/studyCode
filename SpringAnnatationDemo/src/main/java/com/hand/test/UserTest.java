package com.hand.test;

import com.hand.dao.impl.UserdaoImpl;
import com.hand.entity.User;
import com.hand.util.ApplicationContextUtil;
import org.springframework.context.ApplicationContext;

import java.util.Scanner;

public class UserTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext= ApplicationContextUtil.getApplicationContext();
        UserdaoImpl userdao =
                (UserdaoImpl)applicationContext.getBean("userDAOImplTemplate");
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入id：");
        int id=scanner.nextInt();
        System.out.println("请输入姓名");
        String userName=scanner.next();
        System.out.println("请输入年龄");
        String userAge=scanner.next();
        System.out.println("请输入地址");
        String userAddress=scanner.next();
        User user = new User(id,userName,userAge,userAddress);
        userdao.insertByJdbcTemlate(user);

    }
}
