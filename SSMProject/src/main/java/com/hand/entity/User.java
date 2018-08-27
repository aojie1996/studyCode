package com.hand.entity;


import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID=1L;
    private Integer id; //自增主键ID
    private String username; //用户名
    private String password; //密码
    private String truename; //真实姓名
    private int flag; //标记，为1时表示用户启用，0为禁用，默认为禁用

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTruename() {
        return truename;
    }

    public void setTruename(String truename) {
        this.truename = truename;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public User() {
    }

    public User(Integer id, String username, String password, String truename, int flag) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.truename = truename;
        this.flag = flag;
    }
}
