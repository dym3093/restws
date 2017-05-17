package com.dayton.rest.mq.service;/**
 * Created by daimian on 17-5-17.
 */

import org.springframework.stereotype.Service;

/**
 * 客户相关service
 *
 * @author Damian
 * @create 2017-05-17 下午6:22
 **/
@Service("clientPushService")
public class ClientPushService implements PushService{

    @Override
    public void push(Object info) {

    }
}
