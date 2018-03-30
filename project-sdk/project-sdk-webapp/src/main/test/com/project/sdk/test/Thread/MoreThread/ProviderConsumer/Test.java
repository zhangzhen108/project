package com.project.sdk.test.Thread.MoreThread.ProviderConsumer;

/**
 * @desc:
 * @author: zhangzhen
 * @create time: 2018/3/30
 */
public class Test {


    /**
     * 多线程生产和消费实例
     */
    public static void ProviderConsumer(){
        Person p=new Person();
        Producer producer=new Producer(p);
        Thread threadProducer=new Thread(producer);
        Consumer consumer=new Consumer(p);
        Thread threadConsumer=new Thread(consumer);
        threadProducer.start();
        threadConsumer.start();
    }
    public static void main(String[] args) {

        ProviderConsumer();
    }


}
