package com.young.sdkdemo.collect.list;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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

    @Test
    public void test02() {
        String[] words = {"Hello", "world"};
        int i = Runtime.getRuntime().availableProcessors();
        System.out.println(i);
    }


    //1,2,3,4,5


    @Test
    public void test03() {
        Long reduce = Stream.iterate(1L, i -> i + 1)
                .limit(10)
                .parallel()
                .reduce(0L, Long::sum);
        System.out.println(reduce);
    }
}
