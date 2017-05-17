package com.dayton.rest.mq.service;/**
 * Created by daimian on 17-5-17.
 */

import com.alibaba.fastjson.JSON;
import com.dayton.rest.mq.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;


/**
 * 用户消息推送服务类
 *
 * @author Damian
 * @create 2017-05-17 下午5:31
 **/
@Service()
public class UserPushService implements PushService{

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    @Qualifier("userServiceQueue")
    private Destination destination;

    @Override
    public void push(final Object info) {
        pushExecutor.execute(new Runnable() {
            @Override
            public void run() {
                jmsTemplate.send(destination, new MessageCreator() {
                    @Override
                    public Message createMessage(Session session) throws JMSException {
                        User user = (User) info;
                        return session.createTextMessage(JSON.toJSONString(user));
                    }
                });
            }
        });
    }
}
