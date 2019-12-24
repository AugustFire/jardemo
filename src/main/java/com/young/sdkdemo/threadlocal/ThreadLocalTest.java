package com.young.sdkdemo.threadlocal;

import org.junit.Test;


/**
 * create_time 2019/11/14
 *
 * @author yzx
 */
public class ThreadLocalTest {

    @Test
    public void test01() {

        ThreadLocal<String> threadLocal = new ThreadLocal<>();

        threadLocal.set("1q");
        threadLocal.set("23");
        String s = threadLocal.get();
        System.out.println(s);

    }

    @Test
    public void test02() {
        System.out.println(!true&&false);
    }
}