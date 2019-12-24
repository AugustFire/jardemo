package com.young.sdkdemo.concurrency.threadpool;

import org.junit.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author: yangzongxu
 * @date: 2018/9/19
 * @description: 线程池
 */
public class ThreadPoolDemo {

    public static void main(String[] args) throws InterruptedException {

//        Executor service =
        ExecutorService service = Executors.newFixedThreadPool(20);


        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        CountDownLatch countDownLatch = new CountDownLatch(100);
        //avg(100/3x1 = 33sec)
        LocalDateTime now = LocalDateTime.now();

        for (Integer integer : list) {
            TaskRunner taskRunner = new TaskRunner(integer,countDownLatch);
            service.execute(taskRunner);
        }
        countDownLatch.await();
        LocalDateTime end = LocalDateTime.now();
        long seconds = Duration.between(now, end).getSeconds();
        System.out.println("Task++++++++"+seconds);
        service.shutdown();
    }
}
