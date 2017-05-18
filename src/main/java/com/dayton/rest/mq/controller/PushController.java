package com.dayton.rest.mq.controller;/**
 * Created by daimian on 17-5-17.
 */

import com.dayton.rest.mq.domain.*;
import com.dayton.rest.mq.service.PushService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping( value = "user", method = RequestMethod.POST)
    @ResponseBody
    public ResultResponse userPush(User info){
        return this.commSend(info);
    }

    @RequestMapping( value = "news", method = RequestMethod.POST)
    @ResponseBody
    public ResultResponse newsPush(User info){
        return this.commSend(info);
    }

    @RequestMapping( value = "client", method = RequestMethod.POST)
    @ResponseBody
    public ResultResponse clientPush(User info){
        return this.commSend(info);
    }

    /**
     * 通用发送方法
     * @param obj
     * @return ResultResponse
     */
    private ResultResponse commSend(Object obj){
        ResultResponse response = null;
        PushService pushService = null;
        BaseEntity entity = null;
        try {
            if (obj!=null){
                if (obj instanceof User){
                    pushService = userPushService;
                    entity = (User) obj;
                } else if (obj instanceof News){
                    pushService = newsPushService;
                    entity = (News) obj;
                } else if (obj instanceof Client){
                    pushService = clientPushService;
                    entity = (Client) obj;
                }
                if (pushService!=null && entity!=null) {
                    pushService.push(entity);
                    response.setData(entity.toString());
                }
            }
        } catch (Exception e){
            e.printStackTrace();
            response = new ResultResponse(false, e.getMessage());
        }
        return response;
    }

}
