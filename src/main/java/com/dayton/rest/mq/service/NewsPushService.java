package com.dayton.rest.mq.service;/**
 * Created by daimian on 17-5-17.
 */

import com.alibaba.fastjson.JSON;
import com.dayton.rest.mq.domain.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;

/**
 * 新闻推送
 *
 * @author Damian
 * @create 2017-05-17 下午5:56
 **/
@Service("newsPushService")
public class NewsPushService implements PushService{

    @Autowired
    private JmsTemplate jmsTemplate;

    @Resource(name = "newsServiceQueue")
    private Destination destination;

    @Override
    public void push(Object info) {
        pushExecutor.submit(() -> jmsTemplate.send(destination, session -> {
            News news = (News) info;
            return session.createTextMessage(JSON.toJSONString(news));
        }));
    }

    /**
        pushExecutor.submit(new Runnable() {
        @Override
        public void run() {
            jmsTemplate.send(destination, new MessageCreator() {
                @Override
                public Message createMessage(Session session) throws JMSException {
                    News news = (News) info;
                    return session.createTextMessage(JSON.toJSONString(news));
                }
            });
        }
    });
     */
}
