package com.hand.event;

import com.hand.dao.impl.EmailDAOImpl;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class EmailNotifier implements ApplicationListener {
    @Override
    //该方法会在容器发生事件时触发
    public void onApplicationEvent(ApplicationEvent event) {
            if (event instanceof MailSendEvent){
                //只处理MailSendEvent，发送email通知
                MailSendEvent mailSendEvent=(MailSendEvent)event;
                System.out.println("邮件的主题是："+mailSendEvent.getTheme());
                System.out.println("邮件的主要内容是："+mailSendEvent.getText());
                System.out.println("邮件的接受人为："+mailSendEvent.getReceiver());
                EmailDAOImpl e=new EmailDAOImpl();
                e.addEmail(mailSendEvent);
            }else{
                //System.out.println("容器本身的事件："+event);
            }
    }
}
