package com.young.sdkdemo.datetime;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Date;

/**
 * @author: yzx
 * @date: 2018/8/27
 * @description: 测试日期时间类
 */
public class DateTimeTest {

    /**
     * 毫秒值转LocalDateTime
     */
    @Test
    public void test01() {
        long currentTimeMillis = System.currentTimeMillis();
        Instant instant = Instant.ofEpochMilli(currentTimeMillis);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        System.out.println(localDateTime);
    }

    /**
     * LocalDateTime转毫秒值
     */
    @Test
    public void test02() {
        LocalDateTime localDateTime = LocalDateTime.now();
        long epochMilli = localDateTime.toInstant(ZoneOffset.ofHours(8)).toEpochMilli();
        System.out.println(epochMilli);
        System.out.println(System.currentTimeMillis());
    }

}
