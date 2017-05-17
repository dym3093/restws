package com.dayton.rest.mq.service;/**
 * Created by daimian on 17-5-16.
 */

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * 生产者service
 *
 * @author Damian
 * @create 2017-05-16 下午5:04
 **/
@Service
public class ProducerService {

    @Resource(name="jmsTemplate")
    private JmsTemplate jmsTemplate;

    /**
     * 把消息发送到指定目的地
     * @param destination 目的地(Destination)
     * @param msg 消息
     */
    public void sendMessage(Destination destination, final String msg){
        sendMessage(destination.toString(), msg);
    }

    /**
     * 把消息发送到指定目的地
     * @param destination 目的地(String)
     * @param msg 消息
     */
    public void sendMessage(String destination, final String msg){
        System.out.println(Thread.currentThread().getName()+" 向队列 "
                            +destination+" 发送消息---> "+msg);
        jmsTemplate.send(destination, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(msg);
            }
        });
    }

    /**
     * 把消息发送到默认目的地
     * @param msg 消息
     */
    public void sendMessage(final String msg){
        String destination = jmsTemplate.getDefaultDestinationName();
        System.out.println(Thread.currentThread().getName()+" 向队列 "
                +destination+" 发送消息---> "+msg);

        jmsTemplate.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(msg);
            }
        });
    }


}
