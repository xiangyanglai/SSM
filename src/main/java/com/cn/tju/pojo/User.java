package com.cn.tju.pojo;

import java.util.Date;

public class User {
    private Integer userId;

    private String userName;

    private String userPwd;

    private String userPhone;

    private String userEmail;

    private Date datetime;

    private Integer userFlag;

    private Integer userRole;

    private String userNote;

    public User(Integer userId, String userName, String userPwd, String userPhone, String userEmail, Date datetime, Integer userFlag, Integer userRole, String userNote) {
        this.userId = userId;
        this.userName = userName;
        this.userPwd = userPwd;
        this.userPhone = userPhone;
        this.userEmail = userEmail;
        this.datetime = datetime;
        this.userFlag = userFlag;
        this.userRole = userRole;
        this.userNote = userNote;
    }

    public User() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd == null ? null : userPwd.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public Integer getUserFlag() {
        return userFlag;
    }

    public void setUserFlag(Integer userFlag) {
        this.userFlag = userFlag;
    }

    public Integer getUserRole() {
        return userRole;
    }

    public void setUserRole(Integer userRole) {
        this.userRole = userRole;
    }

    public String getUserNote() {
        return userNote;
    }

    public void setUserNote(String userNote) {
        this.userNote = userNote == null ? null : userNote.trim();
    }
}