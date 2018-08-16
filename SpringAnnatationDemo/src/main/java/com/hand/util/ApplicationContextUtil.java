package com.hand.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextUtil {
    private static ApplicationContext applicationContext = null;

    public static ApplicationContext getApplicationContext(){
         if (applicationContext==null){
             applicationContext=
                     new ClassPathXmlApplicationContext("ApplicationContext.xml");
         }
         return applicationContext;
     }
}
