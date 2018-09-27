package com.young.sdkdemo.collect.list;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author: yangzongxu
 * @date: 2018/9/7
 * @description:
 */
public class Demo1 {
    @Test
    public void test01() {
        Integer[] arr = {0, 1, 2, 3, 4};
        List<Integer> integers = Arrays.asList(arr);
        List<Integer> collect = integers.stream().filter(integer -> integer > 2).collect(toList());
        System.out.println(collect);
    }
}
