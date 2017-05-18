package com.dayton.rest.mq.service;
/**
 * Created by daimian on 17-5-17.
 */

import com.alibaba.fastjson.JSON;
import com.dayton.rest.mq.domain.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * 客户相关service
 *
 * @author Damian
 * @create 2017-05-17 下午6:22
 **/
@Service("clientPushService")
public class ClientPushService implements PushService{

    @Autowired
    private JmsTemplate jmsTemplate;

    @Resource(name = "clientServiceQueue")
    private Destination destination;

    @Override
    public void push(Object info) {
        pushExecutor.submit(new Runnable() {
            @Override
            public void run() {
                jmsTemplate.send(destination, new MessageCreator() {
                    @Override
                    public Message createMessage(Session session) throws JMSException {
                        Client client = (Client) info;
                        return session.createTextMessage(JSON.toJSONString(client));
                    }
                });
            }
        });
    }

}
