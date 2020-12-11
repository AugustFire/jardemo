package com.young.sdkdemo.collect.map;

import org.junit.Test;

import java.sql.SQLOutput;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static org.junit.Assert.assertEquals;

/**
 * create_time 2019/9/25
 *
 * @author yzx
 */
public class MapTest {

    @Test
    public void test() throws InterruptedException {
        LocalDateTime now = LocalDateTime.now();
        ArrayList<Integer> nums = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            nums.add(i*10);
        }
        //0-10-20-30-...-90
        List<List<Integer>> lists = ThreadUtils.forkJoinTasks(nums, 10, integer -> {
            //if (integer == 10) {
            //    throw new RuntimeException("mistake");
            //}
            int end = integer + 10;
            ArrayList<Integer> integers = new ArrayList<>();
            System.out.println(Thread.currentThread().getName() +"--->"+integer);
            for (Integer i = integer; i < end; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                integers.add(i);
            }
            return integers;
        });
        List<Integer> collect = lists.parallelStream().peek(i->{
            System.out.println(Thread.currentThread().getName()+i);
        }).flatMap(List::stream).collect(Collectors.toList());

        lists.forEach(
                System.out::println
        );
        System.out.println("------->");
        collect.forEach(
                System.out::println
        );
        LocalDateTime end = LocalDateTime.now();
        long seconds = Duration.between(now, end).getSeconds();
        System.out.println("耗时___________"+seconds);
        TimeUnit.SECONDS.sleep(10);
    }

    @Test
    public void test2() {
        List<Integer> integers = countPageTotalNum(11, 2);
        System.out.println(integers);
    }
    public static List<Integer> countPageTotalNum(long availableNum, Integer pageSize) {
        double ceil = Math.ceil((double) availableNum / pageSize);
        int res = (int) ceil;
        return IntStream.rangeClosed(1, res).boxed().collect(Collectors.toList());
    }
}
