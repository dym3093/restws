package com.dayton.rest.mq.filter;/**
 * Created by daimian on 17-5-16.
 */

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * 队列消息监听器
 *
 * @author Damian
 * @create 2017-05-16 下午6:06
 **/
public class QueueMessageListener implements MessageListener{

    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        try {
            System.out.println("QueueMessageListener 监听到了消息： \t "+textMessage.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

}
