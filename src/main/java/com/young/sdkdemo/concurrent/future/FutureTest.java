package com.young.sdkdemo.concurrent.future;

import com.young.sdkdemo.concurrent.TestUtils;
import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Zongxu.Yang
 * create at 2020/12/11
 */
public class FutureTest {

    /**
     * Runnable
     * JDK1.0
     * 没有参数
     * 没有返回值
     * 没办法抛出异常
     */
    private static final Runnable errRunnable = () -> {
        throw new RuntimeException("err_runnable");
    };

    private static final Runnable runnable = () -> {
        System.out.println("I am runnable body");
    };

    /**
     * 异常概率 0.5
     */
    private static final Callable<Integer> callable = () -> {
        System.out.println("call begin");
        int i = TestUtils.randomInteger(10);
        if (i % 2 == 0) {
            throw new RuntimeException("err_call");
        }
        return i;
    };

    /**
     * 测试runnable遇到异常
     */
    @Test
    public void testExceptionRunnable() {
        Thread exceptionThread = new Thread(errRunnable);
        exceptionThread.start();
        TestUtils.sleep(1);
        System.out.println(exceptionThread.isAlive());
    }

    /**
     * 测试callable遇到异常
     */
    @Test
    public void testExceptionCallable() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> f = executorService.submit(callable);
        System.out.println(f.get());
        TestUtils.sleep(2);
    }

}
