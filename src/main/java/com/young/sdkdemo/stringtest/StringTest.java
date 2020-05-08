package com.young.sdkdemo.stringtest;

import org.junit.Test;

import java.util.regex.Pattern;

/**
 * create_time 2020/1/13
 *
 * @author yzx
 */
public class StringTest {

    @Test
    public void test() {
        String pattern = "第\\d{1,2}单元";
        String str = "第5单元";
        System.out.println(Pattern.matches(pattern, str));
    }
}
