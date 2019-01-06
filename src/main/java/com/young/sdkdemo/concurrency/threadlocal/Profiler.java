package com.young.sdkdemo.concurrency.threadlocal;

import java.util.concurrent.TimeUnit;

/**
 * Project: jardemo.
 * Author:YZX
 * Time:21:02 2019/1/6
 * Description:ThreadLocal
 */
public class Profiler {
    private static final ThreadLocal<Long> TIME_THREAD_LOCAL = new ThreadLocal<>();

    public static final void begin() {
        TIME_THREAD_LOCAL.set(System.currentTimeMillis());
    }

    public static final long end() {
        return System.currentTimeMillis()  - TIME_THREAD_LOCAL.get();
    }

    public static void main(String[] args) {
        Profiler.begin();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Profiler.end();
        System.out.println("总耗时"+Profiler.end());

    }
}
