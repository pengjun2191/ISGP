package com.example.demo.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.math.BigInteger;
import java.util.Date;


@Entity
@Table(name = "p_sys_user")
public class PSysUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;


    @Column(name="user_name")
    @NotEmpty(message = "用户名不能为空")
    private String userName;

    @Column(name="user_password")
    @NotBlank(message = "密码不能为空")
    private String userPw;

    @Column(name="user")
    private String user;

    @Column(name="user_salt")
    private BigInteger userSalt;

    @Column(name="user_phone")
    private String userPhone;

    @Column(name="user_address")
    private String userAddr;

    @Column(name="user_email")
    @Email(message = "邮箱地址不正确")
    private String userEmail;

    @Column(name="user_auth_type")
    @NotBlank(message = "需要身份验证类型")
    private String userAuthType;

    @Column(name="user_auth_number")
    @NotBlank(message = "请输入身份验证信息")
    private String userAuthNum;

    @Column(name="user_age")
    private Integer userAge;

    @Column(name="user_status")
    private short userStatus;

    @Column(name="user_create_date")
    private Date userCreateDate;

    public short getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(short userStatus) {
        this.userStatus = userStatus;
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
        this.userName = userName;
    }

    public String getUserPw() {
        return userPw;
    }

    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public BigInteger getUserSalt() {
        return userSalt;
    }

    public void setUserSalt(BigInteger userSalt) {
        this.userSalt = userSalt;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserAddr() {
        return userAddr;
    }

    public void setUserAddr(String userAddr) {
        this.userAddr = userAddr;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserAuthType() {
        return userAuthType;
    }

    public void setUserAuthType(String userAuthType) {
        this.userAuthType = userAuthType;
    }

    public String getUserAuthNum() {
        return userAuthNum;
    }

    public void setUserAuthNum(String userAuthNum) {
        this.userAuthNum = userAuthNum;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public Date getUserCreateDate() {
        return userCreateDate;
    }

    public void setUserCreateDate(Date userCreateDate) {
        this.userCreateDate = userCreateDate;
    }
}
