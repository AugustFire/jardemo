package com.young.sdkdemo.collect.map;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Zongxu.Yang
 * create at 2020/12/11
 */
public class Test {

    @org.junit.Test
    public void test() {
        //CompletableFuture.
        List<Integer> collect = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());
        //collect.parallelStream()
    }
}
