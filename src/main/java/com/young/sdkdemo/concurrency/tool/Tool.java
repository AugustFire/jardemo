package com.young.sdkdemo.concurrency.tool;


import org.junit.Test;
import sun.rmi.runtime.Log;

import java.sql.Time;
import java.util.Random;
import java.util.concurrent.*;

/**
 * create_time 2019/12/24
 *
 * @author yzx
 */
@SuppressWarnings("all")
public class Tool {

    /**
     * 屏障-测试
     * Cyclic Barrier Test
     */
    @Test
    public void cyclicBarrierTest() {
        CyclicBarrier barrier = new CyclicBarrier(2, new Runnable() {
            @Override
            public void run() {
                System.out.println("OK~~~~~~~~~");
            }
        });
        new Thread(() -> {
            try {
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }

            System.out.println(1);
        }).start();
        try {
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println(2);
    }


    /**
     * Exchanger 测试
     */
    @Test
    public void exchangerTest() {
        final Exchanger<String> exchanger = new Exchanger<>();
        ExecutorService threadPool = Executors.newFixedThreadPool(2);

        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String A = "银行流水A";
                    String x = exchanger.exchange("S");
                    System.out.println("X______" + x);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String B = "银行流水B";
//                    String A = exchanger.exchange("B");
//                    System.out.println("A___________"+A);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        while (true) {

        }

    }


    /**
     * Semaphore 测试
     */
    @Test
    public void semaphoreTest() {
        ExecutorService exec = Executors.newCachedThreadPool();
        Semaphore sp = new Semaphore(5);
        for (int i = 0; i < 1; i++) {
            final int NO = i;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        sp.acquire();
                        System.out.println("Access:" + NO);
                        Thread.sleep(new Random().nextInt(3000));
                        System.out.println("Release"+NO);
                        sp.release();
                        //
                        System.out.println(NO+"-----" + sp.availablePermits());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            };
            exec.execute(runnable);


        }

        try {
            TimeUnit.SECONDS.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
