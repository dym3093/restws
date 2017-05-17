package com.dayton.rest.mq.domain;
/**
 * Created by daimian on 17-5-17.
 */

import java.io.Serializable;

/**
 * 用户类
 *
 * @author Damian
 * @create 2017-05-17 下午5:09
 **/
public class User implements Serializable{

    private Long id;

    private String userName;

    private String password;

    private String gender;

    private Integer age;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User[" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ']';
    }

}
