package com.young.sdkdemo.collect.list;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Project: jardemo.
 * Author:YZX
 * Time:0:01 2018/10/31
 * Description:线程调度
 */
public class Demo2 {



    public static void main(String[] args) throws ExecutionException, InterruptedException {
        userCompleteFuture();
    }


    public static void work(String name) {
        Random random = new Random();
        System.out.println(name+"start at"+ LocalTime.now());
        try {
            TimeUnit.SECONDS.sleep(random.nextInt(10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name+"end at"+ LocalTime.now());
    }

    public static void userCompleteFuture() throws ExecutionException, InterruptedException {
        System.out.println("userComplete");
        CompletableFuture<Void> a = CompletableFuture.runAsync(() -> work("A"));
        CompletableFuture<Void> b = CompletableFuture.runAsync(() -> work("B"));
        a.runAfterEither(b,()->work("c")).get();
        Thread.sleep(10000);
    }

}
