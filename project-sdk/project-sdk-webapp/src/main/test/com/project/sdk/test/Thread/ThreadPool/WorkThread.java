package com.project.sdk.test.Thread.ThreadPool;

import java.util.concurrent.BlockingQueue;

/**
 * @desc:
 * @author: zhangzhen
 * @create time: 2018/3/30
 */
public class WorkThread implements Runnable{


    private BlockingQueue<Runnable> workQueue;
    private WorkThread(BlockingQueue<Runnable> workQueue){
        this.workQueue=workQueue;
    }
    @Override
    public void run() {
        try{
            Runnable runnable=workQueue.take();
            runnable.run();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
