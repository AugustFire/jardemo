package com.young.sdkdemo.concurrent.callable;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * @author: yangzongxu
 * @date: 2018/9/7
 * @description:
 */
public class Demo1 {

    @Test
    public void test01() {
        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<String> future = service.submit(() -> "ok~");
        try {
            String result = future.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
