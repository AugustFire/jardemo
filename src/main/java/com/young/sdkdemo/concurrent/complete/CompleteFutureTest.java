package com.young.sdkdemo.concurrent.complete;

import com.young.sdkdemo.concurrent.TestUtils;
import com.young.sdkdemo.concurrent.future.FutureTest;
import org.junit.Test;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;


/**
 * callable-future
 * 无法实现任务编排 比如一个任务阶段依赖另一个任务
 * 无法链式执行
 *
 *
 * @author Zongxu.Yang
 *
 * @see FutureTest
 * create at 2020/12/11
 */
public class CompleteFutureTest {

    @Test
    public void testRunAsync() {
        //CompletableFuture.runAsync(TestUtils::sleep);
    }
}
