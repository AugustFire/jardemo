package com.young.sdkdemo.concurrency.base;

import java.util.concurrent.TimeUnit;

/**
 * create_time 2019/12/15
 *
 * @author yzx
 */
public class Join {
    public static void main(String[] args) throws InterruptedException {
        Thread previous = Thread.currentThread();
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(new Domino(previous), "Thread-" + String.valueOf(i));
            thread.start();
            previous = thread;
        }
        TimeUnit.SECONDS.sleep(5);
        System.out.println(Thread.currentThread().getName()+"terminate");

    }

    static class Domino implements Runnable {

        private Thread thread;

        public Domino(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"terminate");

        }
    }
}

