package com.young.sdkdemo.file;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;

/**
 * create_time 2019/10/29
 *
 * @author yzx
 */
public class FileTest {

    @Test
    public void test() throws UnknownHostException {
//        String s = "\\data0\\app\\resource\\music_assistant\\music_classroom\\encryption\\五年级\\上册\\第4单元\\演唱\\牧场上的家\\课堂活动\\内容";
//        String[] split = s.split("encryption");
//        System.out.println(split[1]);

        System.out.println(InetAddress.getLocalHost().getHostName());

    }
}
