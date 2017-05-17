package com.dayton.rest.mq;/**
 * Created by daimian on 17-5-16.
 */

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 消费者
 *
 * @author Damian
 * @create 2017-05-16 下午2:36
 **/
public class Consumer {

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
    //当前线程实例
    ThreadLocal<MessageConsumer> threadLocal = new ThreadLocal<MessageConsumer>();

    public void init(){
        try {
            connectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKEN_URL);
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public void getMessage(String disname){
        try {
            Queue queue = session.createQueue(disname);
            MessageConsumer consumer;
            if (threadLocal.get()!=null){
                consumer = threadLocal.get();
            } else {
                consumer = session.createConsumer(queue);
                threadLocal.set(consumer);
            }
            while (true){
                Thread.sleep(1000);
                TextMessage msg = (TextMessage) consumer.receive();
                if (msg!=null){
                    msg.acknowledge();
                    System.out.println(Thread.currentThread().getName()+": Consumer: 二代正在花钱..., 花钱 msg: "
                            +msg.getText()+"--->"+count.getAndIncrement());
                } else {
                    break;
                }
            }
        } catch (JMSException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
