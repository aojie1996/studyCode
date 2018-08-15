package com.hand.event;


import org.springframework.context.ApplicationEvent;


public class MailSendEvent extends ApplicationEvent {
    private String theme;
    private String text;
    private String receiver;
    private Object object;

    public MailSendEvent(Object source) {
        super(source);
    }

    public MailSendEvent(Object source, String theme, String text, String receiver,Object object) {
        super(source);
        this.theme = theme;
        this.text = text;
        this.receiver = receiver;
        this.object=object;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
