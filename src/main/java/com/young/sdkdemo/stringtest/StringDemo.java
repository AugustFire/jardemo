package com.young.sdkdemo.stringtest;

import org.junit.Test;

/**
 * @author: yzx
 * @date: 2018/8/24
 * @description: 关于String常用方法的测试类
 */
public class StringDemo {

    /**
     * 测试string.format
     */
    @Test
    public void stringMethodTest() {
        String hello = String.format("test:%s", "hello");
        System.out.println(hello);
    }
}
