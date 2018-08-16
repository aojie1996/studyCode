package com.hand.entity;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.stereotype.Component;


public class User {
    private Integer id;
    private String userName;
    private String userAge;
    private String userAddress;
    private BasicDataSource basicDataSource;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAge() {
        return userAge;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public User(Integer id, String userName, String userAge, String userAddress, BasicDataSource basicDataSource) {
        this.id = id;
        this.userName = userName;
        this.userAge = userAge;
        this.userAddress = userAddress;
        this.basicDataSource = basicDataSource;
    }

    public User(Integer id, String userName, String userAge, String userAddress) {
        this.id = id;
        this.userName = userName;
        this.userAge = userAge;
        this.userAddress = userAddress;
    }

    public User() {
    }

    public BasicDataSource getBasicDataSource() {
        return basicDataSource;
    }

    public void setBasicDataSource(BasicDataSource basicDataSource) {
        this.basicDataSource = basicDataSource;
    }
}
