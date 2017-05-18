package com.dayton.rest.mq.domain;/**
 * Created by daimian on 17-5-18.
 */

import java.io.Serializable;

/**
 * 返回结果集
 *
 * @author Damian
 * @create 2017-05-18 下午1:13
 **/
public class ResultResponse implements Serializable{

    private Long id;
    //状态码
    private Integer statusCode;
    //提示信息
    private String message;
    //数据
    private String data;
    //是否成功 true:成功，false:失败
    private Boolean success;

    public ResultResponse(Boolean success, String message) {
        setSuccess(success);
        setMessage(message);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "ResultResponse[" +
                "id=" + id +
                ", statusCode=" + statusCode +
                ", message='" + message + '\'' +
                ", data='" + data + '\'' +
                ", success='" + success + '\'' +
                ']';
    }

}
