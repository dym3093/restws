package com.dayton.rest.mq.controller;/**
 * Created by daimian on 17-5-16.
 */

import com.dayton.rest.mq.service.ConsumerService;
import com.dayton.rest.mq.service.ProducerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * 消息controller
 *
 * @author Damian
 * @create 2017-05-16 下午5:34
 **/
@Controller
public class MessageController {

    private Logger log = LoggerFactory.getLogger(MessageController.class);

    @Resource(name = "demoQueueDestination")
    private Destination destination;

    //队列消息生产者
    @Resource(name = "producerService")
    private ProducerService producerService;

    @Resource(name = "consumerService")
    private ConsumerService consumerService;

    /**
     * 发送消息队列
     * @param msg 消息
     */
    @RequestMapping(value = "/sendMessage", method = RequestMethod.POST)
    @ResponseBody
    public void send(String msg){
        log.info(Thread.currentThread().getName()+" ---- send to jms begin ... ");
        log.info("msg: "+msg);
        producerService.sendMessage(msg);
        log.info(Thread.currentThread().getName()+" ---- send to jms end !!! ");
    }

    /**
     * 接收消息队列
     * @return Object 消息队列中的对象
     */
    @RequestMapping(value = "/receiveMessage", method = RequestMethod.GET)
    @ResponseBody
    public Object receive(){
        log.info(Thread.currentThread().getName()+" ---- receive from jms begin ... ");
        TextMessage tm = consumerService.receive(destination);
        try {
            log.info(Thread.currentThread().getName()+" ---- receive from jms message: "+ tm.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
        log.info(Thread.currentThread().getName()+" ---- receive from jms end !!! ");
        return tm;
    }

}
