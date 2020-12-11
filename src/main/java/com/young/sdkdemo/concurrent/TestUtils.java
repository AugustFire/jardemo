package com.young.sdkdemo.concurrent;

import lombok.SneakyThrows;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author Zongxu.Yang
 * create at 2020/12/11
 */
public class TestUtils {

    /**

     * 现场睡眠方法
     * @param second second
     */
    @SneakyThrows
    public static void sleep(Integer second) {
        TimeUnit.SECONDS.sleep(second);
    }

    public static int randomInteger(int endExclusive) {
        return new Random().nextInt(endExclusive);
    }
}
