package com.young.sdkdemo.stringtest;

import com.young.sdkdemo.datetime.DateDemo;
import org.junit.Test;

import java.util.Date;
import java.util.UUID;

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

        for (int i = 0; i < 100; i++) {
            System.out.println(UUID.randomUUID().toString().replace("-",""));
        }
    }

    @Test
    public void testV1() {
        System.out.println(123);
    }
}
