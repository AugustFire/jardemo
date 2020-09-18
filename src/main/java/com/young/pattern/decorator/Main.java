package com.young.pattern.decorator;


import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * 装饰器注重的是覆盖扩展
 *
 * @author yzx
 * create_time 2020/9/4
 */
public class Main {
    public static void main(String[] args) {
        ThreadLocal<String> stringThreadLocal1 = new ThreadLocal<>();
        stringThreadLocal1.set("12");
        ThreadLocal<String> stringThreadLocal2 = new ThreadLocal<>();
        stringThreadLocal2.set("12");
        // System.out.println(s);

    }
}
