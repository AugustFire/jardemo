package com.young.sdkdemo.datetime;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

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

    @Test
    public void test02() {

        LocalDate now = LocalDate.of(2018, 10, 10);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyMMdd");
        String format = now.format(fmt);

        System.out.println(format+">XXXXXXXX");


        int year = now.getYear();
        int month = now.getMonth().getValue();
        int dayOfMonth = now.getDayOfMonth();
        System.out.println(year);
        System.out.println(month);
        System.out.println(dayOfMonth);


        System.out.println(System.currentTimeMillis());

    }

    @Test
    public void test03() {
        System.out.println(String.valueOf(System.currentTimeMillis()));
        long timestamp = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        System.out.println(timestamp);

        LocalDateTime localDateTime = LocalDateTime.ofEpochSecond(timestamp / 1000, 0, ZoneOffset.ofHours(8));
        System.out.println(localDateTime);
    }

    @Test
    public void test04() {
        System.out.println(LocalTime.now());
        System.out.println(LocalDateTime.now());

    }
}
