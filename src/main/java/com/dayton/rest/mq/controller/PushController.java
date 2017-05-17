package com.dayton.rest.mq.controller;/**
 * Created by daimian on 17-5-17.
 */

import com.dayton.rest.mq.service.PushService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * 消息推送控制器
 *
 * @author Damian
 * @create 2017-05-17 下午5:53
 **/
@Controller
@RequestMapping("/push/")
public class PushController {

    @Resource(name = "userPushService")
    private PushService userPushService;

    @Resource(name = "newsPushService")
    private PushService newsPushService;

    @Resource(name = "clientPushService")
    private PushService clientPushService;



}
