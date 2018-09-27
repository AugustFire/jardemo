package com.young.sdkdemo.datetime;

import org.junit.Test;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;

/**
 * @author: yzx
 * @date: 2018/8/27
 * @description: 测试日期时间类
 */
public class DateDemo {

    @Test
    public void test01() {
        //今天的日期
        LocalDate now = LocalDate.now();
        int year = now.getYear();
        Month month = now.getMonth();
        DayOfWeek dayOfWeek = now.getDayOfWeek();

        System.out.println(year+"#"+month+"#"+dayOfWeek);
        System.out.println(now);

        Instant now1 = Instant.now();
        System.out.println(now1);

    }

}
