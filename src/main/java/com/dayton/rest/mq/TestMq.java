package com.dayton.rest.mq;/**
 * Created by daimian on 17-5-16.
 */


/**
 * 测试
 *
 * @author Damian
 * @create 2017-05-16 下午2:56
 **/
public class TestMq {

    public static void main(String[] args){
    }

    public void testDemo(){
        Producter producter = new Producter();
        producter.init();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        TestMq testMq = new TestMq();
        new Thread(testMq.new ProductorMq(producter)).start();
        new Thread(testMq.new ProductorMq(producter)).start();
        new Thread(testMq.new ProductorMq(producter)).start();
        new Thread(testMq.new ProductorMq(producter)).start();
        new Thread(testMq.new ProductorMq(producter)).start();
    }
    private class ProductorMq implements Runnable{

        private Producter producter;

        public ProductorMq(Producter producter){
            this.producter = producter;
        }

        @Override
        public void run() {
            while (true){
                try {
                    producter.sendMessage("dolphin_MQ");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
