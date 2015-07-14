package com.yintai.demo.pojo;

public class User {
    /** 客户 ID. */
    private String userId;
    /** 客户姓名. */
    private String userName;

    public User(String userId, String userName) {
        super();
        this.userId = userId;
        this.userName = userName;
    }

    public User() {
    }
    
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
