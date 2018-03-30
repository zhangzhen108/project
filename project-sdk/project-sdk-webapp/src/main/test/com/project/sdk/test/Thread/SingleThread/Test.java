package com.project.sdk.test.Thread.SingleThread;

import java.util.concurrent.FutureTask;

/**
 * @desc: 单线程测试类
 * @author: zhangzhen
 * @create time: 2018/3/30
 */
public class Test {


    /**
     * Future应用实例
     */
    public static void singerCallable() {

        try{
            CallableThread callable=new CallableThread();
            FutureTask<String> task = new FutureTask<>(callable);
            new Thread(task).start();
            /** task.get  若线程没有执行完 是阻塞等待的 **/
            System.out.println(task.get().toString());
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        singerCallable();
    }
}
