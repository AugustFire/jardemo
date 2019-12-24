package com.young.sdkdemo.collect.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * create_time 2019/9/25
 *
 * @author yzx
 */
public class MapTest {

    @Test
    public void test() {
        HashMap<String, String> map = new HashMap<>(16);
        String put = map.put("k1", "v1");
        String put1 = map.put("k1", "v3");
        System.out.println("DE"+put+"----"+put1);

        map.computeIfAbsent("k2", s -> s+"OK!!");

        System.out.println(map);

    }
}
