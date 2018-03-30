package com.project.sdk.test.Thread.MoreThread.ProviderConsumer;

/**
 * @desc:
 * @author: zhangzhen
 * @create time: 2018/3/30
 */
public class Consumer implements Runnable{
    //共享资源对象
    Person p = null;
    public Consumer(Person p) {
        this.p = p;
    }

    @Override
    public void run() {
        for(int i = 0 ; i < 50 ; i++){
            //消费对象
            p.pop();
        }
    }
}
