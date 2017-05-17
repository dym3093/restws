package com.dayton.rest.mq.service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 推送通用接口
 * Created by daimian on 17-5-17.
 */
public interface PushService {

    //线程池
    ExecutorService pushExecutor = Executors.newFixedThreadPool(10);

    /**
     * 推送
     * @param info 推送的消息
     */
    void push(Object info);

}
