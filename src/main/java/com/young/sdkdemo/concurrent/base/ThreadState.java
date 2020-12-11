package com.young.sdkdemo.concurrent.base;

import java.util.concurrent.TimeUnit;

/**
 * create_time 2019/12/12
 *
 * @author yzx
 */
public class ThreadState {

    public static void main(String[] args) {
        System.out.println("Ok");
        second(3);
        new Thread(new TimeWaiting(),"TimeWaitT").start();
        new Thread(new Waiting(),"WaitT").start();
        new Thread(new Blocked(),"Block_1").start();
        new Thread(new Blocked(),"Block_2").start();
        while (true) {
            second(10);
        }

    }


    static class TimeWaiting implements Runnable {
        @Override
        public void run() {
            while (true) {
                second(100);
            }
        }
    }

    static class Waiting implements Runnable{

        @Override
        public void run() {
            while (true) {
                synchronized (Waiting.class) {
                    try {
                        Waiting.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }
    }


    static class Blocked implements Runnable {

        @Override
        public void run() {
            synchronized (Blocked.class) {
                while (true) {
                    second(100);
                }
            }
        }
    }


    public static void second(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            System.out.println("error_state");
        }

    }
}
