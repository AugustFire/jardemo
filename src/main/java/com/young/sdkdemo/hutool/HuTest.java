package com.young.sdkdemo.hutool;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * create_time 2020/1/6
 *
 * @author yzx
 */
public class HuTest {


    @Test
    public void test() {
        Snowflake sf = IdUtil.getSnowflake(1L, 1L);
        for (int i = 0; i < 8; i++) {
            new Thread(() -> {
                for (int i1 = 0; i1 < 10; i1++) {
                    System.out.println(System.currentTimeMillis()+"____" +sf.nextId());
                }
            }).start();
        }

        while (true) {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
