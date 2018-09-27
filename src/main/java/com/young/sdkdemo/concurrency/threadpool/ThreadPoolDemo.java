package com.young.sdkdemo.concurrency.threadpool;

import org.junit.Test;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author: yangzongxu
 * @date: 2018/9/19
 * @description: 线程池
 */
public class ThreadPoolDemo {
    @Test
    public void test01() {
        int corePoolSize = 1;
        int maxMumPoolSize = 1;
        long keepAliveTime =1;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        LinkedBlockingQueue<Object> objects = new LinkedBlockingQueue<>();

    }
}
