package com.dayton.rest.mq.service;/**
 * Created by daimian on 17-5-16.
 */

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * 消费者service
 *
 * @author Damian
 * @create 2017-05-16 下午5:24
 **/
@Service
public class ConsumerService {

    @Resource(name = "jmsTemplate")
    private JmsTemplate jmsTemplate;

    public TextMessage receive(Destination destination){
        TextMessage textMessage = (TextMessage) jmsTemplate.receive();
        try {
            System.out.println("从队列 "+ destination.toString()+ " 收到了消息： \t "+textMessage.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
        return textMessage;
    }

}
