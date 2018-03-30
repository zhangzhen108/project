package com.project.sdk.test.Thread.MoreThread.FutureTask;

import com.project.sdk.test.Thread.SingleThread.CallableThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @desc: 多线程Future测试类
 * @author: zhangzhen
 * @create time: 2018/3/30
 */
public class Test {


    /**
     * Future应用实例
     */
    public static void singerCallable() {

        try{
            //启动5个线程测试
            int taskSize=5;
            List<Future> list=new ArrayList<>();
            ExecutorService pool = Executors.newFixedThreadPool(taskSize);
            for (int i = 0; i < 5; i++) {
                CallableThread callable=new CallableThread();
               /* 此处也可用FutureTask来实现 Future
                因为FutureTask是Future接口的实现类
                FutureTask futuretask=new FutureTask(callable);
                future future=pool.submit(futuretask);*/
                Future future=pool.submit(callable);
                list.add(future);
            }
            pool.shutdown();
            /** task.get  若线程没有执行完 是阻塞等待的 **/
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i).get().toString());
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        singerCallable();
    }
}
