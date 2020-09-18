package com.young.pattern.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;

/**
 * @author yzx
 * create_time 2020/9/1
 */
public class Main {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        CountDownLatch downLatch = new CountDownLatch(20);
        for (int i = 0; i < 20; i++) {
            Thread thread = new Thread(() -> {
                try {
                    downLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                DoubleCheckSingleton instance = DoubleCheckSingleton.getInstance();
                // StaticBlockSingleton instance = StaticBlockSingleton.getInstance();
                System.out.println(Thread.currentThread().getName() +"-->"+ instance);
            }, "Thread-" + i);
            downLatch.countDown();
            thread.start();
        }
        LocalDateTime end = LocalDateTime.now();
        System.out.println(Duration.between(now, end).toMillis());

        try {
            Constructor<DoubleCheckSingleton> constructor = DoubleCheckSingleton.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            DoubleCheckSingleton doubleCheckSingleton = constructor.newInstance();
            System.out.println(doubleCheckSingleton);

        } catch (NoSuchMethodException | IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
