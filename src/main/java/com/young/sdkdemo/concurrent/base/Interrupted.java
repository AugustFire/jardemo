package com.young.sdkdemo.concurrent.base;

import java.util.concurrent.TimeUnit;

/**
 * create_time 2019/12/15
 *
 * @author yzx
 */
public class Interrupted {

    public static void main(String[] args) throws InterruptedException {

        Thread sleepThread = new Thread(new SleepRunner(), "SleepThread");
        sleepThread.setDaemon(true);


        Thread busyThread = new Thread(new BusyRunner(), "BusyThread");
        busyThread.setDaemon(true);



        sleepThread.start();
        busyThread.start();
        sleep(5);
        sleepThread.interrupt();
        busyThread.interrupt();


        System.out.println("SleepThread inter is " + sleepThread.isInterrupted());
        System.out.println("BusyThread inter is " + busyThread.isInterrupted());

        sleep(10);
        System.out.println(123);
    }

    static class SleepRunner implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class BusyRunner implements Runnable {
        @Override
        public void run() {
            while (true) {
                //System.out.print("Im busy");
            }
        }
    }


    public static void sleep(long seconds) throws InterruptedException {

            TimeUnit.SECONDS.sleep(seconds);


    }

}
