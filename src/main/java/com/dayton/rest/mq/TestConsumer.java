package com.dayton.rest.mq;/**
 * Created by daimian on 17-5-16.
 */


/**
 * 消费者测试
 *
 * @author Damian
 * @create 2017-05-16 下午3:04
 **/
public class TestConsumer {

    public static void main(String[] args){

    }

    public void test(){
        Consumer consumer = new Consumer();
        consumer.init();
        TestConsumer testConsumer = new TestConsumer();

        new Thread(testConsumer.new ConsumerMq(consumer)).start();
        new Thread(testConsumer.new ConsumerMq(consumer)).start();
        new Thread(testConsumer.new ConsumerMq(consumer)).start();
        new Thread(testConsumer.new ConsumerMq(consumer)).start();
        new Thread(testConsumer.new ConsumerMq(consumer)).start();
    }
    private class ConsumerMq implements Runnable{
        Consumer consumer;
        public ConsumerMq(Consumer consumer){
            this.consumer = consumer;
        }

        @Override
        public void run() {
            while (true){
                try {
                    consumer.getMessage("dolphin_MQ");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
