package com.dayton.rest.mq.domain;
/**
 * Created by daimian on 17-5-17.
 */

import java.io.Serializable;

/**
 * 客户信息
 *
 * @author Damian
 * @create 2017-05-17 下午6:13
 **/
public class Client extends BaseEntity implements Serializable{

    private Long id;

    private String name;

    private String address;

    private String mobile;

    public Client() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "Client[" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", mobile='" + mobile + '\'' +
                ']';
    }
}
