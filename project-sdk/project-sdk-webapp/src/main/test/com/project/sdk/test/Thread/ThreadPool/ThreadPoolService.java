package com.project.sdk.test.Thread.ThreadPool;

/**
 * @desc:
 * @author: zhangzhen
 * @create time: 2018/3/30
 */
public interface ThreadPoolService<T extends Runnable> {

    /** 向池内添加任务 **/
    public void add(T t);
    /** 关闭池 **/
    public void shutdown();

}
