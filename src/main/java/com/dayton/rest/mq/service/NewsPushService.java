package com.dayton.rest.mq.service;/**
 * Created by daimian on 17-5-17.
 */

import org.springframework.stereotype.Service;

/**
 * 新闻推送
 *
 * @author Damian
 * @create 2017-05-17 下午5:56
 **/
@Service("newsPushService")
public class NewsPushService implements PushService{

    @Override
    public void push(Object info) {

    }
}
