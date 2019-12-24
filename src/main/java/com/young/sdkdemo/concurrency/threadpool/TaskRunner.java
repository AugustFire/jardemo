package com.young.sdkdemo.concurrency.threadpool;

import sun.rmi.runtime.Log;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * create_time 2019/11/21
 *
 * @author yzx
 */
public class TaskRunner implements Runnable {

    private Integer taskId;

    private CountDownLatch countDownLatch;


    public TaskRunner(Integer taskId, CountDownLatch countDownLatch) {
        this.taskId = taskId;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        int i = taskId % 3;
        try {
            System.out.println(Thread.currentThread().getName()+"_____"+taskId);
            TimeUnit.SECONDS.sleep(i);

        } catch (InterruptedException e) {
            System.out.println("子任务失败");
        }finally {
            countDownLatch.countDown();
        }
    }
}
