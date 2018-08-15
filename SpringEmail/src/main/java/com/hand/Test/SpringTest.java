package com.hand.Test;

import com.hand.dao.impl.EmailDAOImpl;
import com.hand.event.MailSendEvent;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class SpringTest {

    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("ApplicationContext.xml");
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入主题：");
        String theme=scanner.next();
        System.out.println("请输入主要内容");
        String text=scanner.next();
        System.out.println("请输入接受者");
        String receiver=scanner.next();
        //创建一个ApplicationEvent对象
        BasicDataSource basicDataSource= (BasicDataSource) applicationContext.getBean("dataSource");
        MailSendEvent mailSendEvent=new MailSendEvent(
                "ApplicationContext.xml",
                theme,text,receiver,basicDataSource);
        applicationContext.publishEvent(mailSendEvent);

    }
}
