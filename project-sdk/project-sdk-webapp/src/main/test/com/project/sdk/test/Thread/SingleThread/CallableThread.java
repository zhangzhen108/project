package com.project.sdk.test.Thread.SingleThread;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 * @desc:
 * @author: zhangzhen
 * @create time: 2018/3/30
 */
public class CallableThread implements Callable<String>{


    @Override
    public String call() throws Exception {

        Thread.sleep(5000);

        return "7";
    }
}
