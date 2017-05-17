package com.dayton.rest.mq;/**
 * Created by daimian on 17-5-16.
 */

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 生产者
 *
 * @author Damian
 * @create 2017-05-16 下午2:08
 **/
public class Producter {

    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
    private static final String BROKEN_URL = ActiveMQConnection.DEFAULT_BROKER_URL;

    //计数
    AtomicInteger count = new AtomicInteger(0);
    //链接工厂
    ConnectionFactory connectionFactory;
    //链接
    Connection connection;
    //事务/会话
    Session session;

    ThreadLocal<MessageProducer> threadLocal = new ThreadLocal<MessageProducer>();

    public void init(){
        try {
            connectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKEN_URL);
            connection = connectionFactory.createConnection();
            //开启链接
            connection.start();
            //创建事务
            session = connection.createSession(true, Session.SESSION_TRANSACTED);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String disname){
        try {
            Queue queue = session.createQueue(disname);
            //消息生产者
            MessageProducer messageProducer = null;
            if (threadLocal.get()!=null){
                messageProducer = threadLocal.get();
            } else {
                messageProducer = session.createProducer(queue);
                threadLocal.set(messageProducer);
            }
            while (true){
                Thread.sleep(1000);
                int num = count.getAndIncrement();
                //创建一条消息
                TextMessage msg = session.createTextMessage(Thread.currentThread().getName()+"创建者： money打印中.... , count: "+num);
                System.out.println(Thread.currentThread().getName()+"创建者： money打印中.... , count: "+num);
                //发送消息
                messageProducer.send(msg);
                //提交事务
                session.commit();
            }
        } catch (JMSException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
