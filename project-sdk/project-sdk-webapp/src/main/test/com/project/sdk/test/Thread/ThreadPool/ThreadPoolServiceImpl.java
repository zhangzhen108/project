package com.project.sdk.test.Thread.ThreadPool;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @desc: 线程池
 * @author: zhangzhen
 * @create time: 2018/3/30
 */
public class ThreadPoolServiceImpl implements ThreadPoolService{

    /** 存任务的队列 **/
    private static BlockingQueue<Runnable> workQueue=null;
    //工作线程数
    private static List<WorkThread> workThreadList;
    /** 初始化任务池大小 **/
    public ThreadPoolServiceImpl(int poolSize){
        if(workQueue==null){
            workQueue=new ArrayBlockingQueue<Runnable>(poolSize);
        }
    }

    @Override
    public void add(Runnable runnable) {
        try{
            workQueue.put(runnable);

        }catch (Exception e){

        }
    }

    @Override
    public void shutdown() {

    }
}
