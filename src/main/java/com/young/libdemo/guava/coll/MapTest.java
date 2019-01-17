package com.young.libdemo.guava.coll;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.junit.Test;


/**
 * @author yangzongxu
 * @date 2019/1/8
 * @description Guava Map 使用测试
 */
public class MapTest {



    @Test
    public void mapTest01() {
        ImmutableList<String> names = ImmutableList.of("Bob", "Jack", "Lucy");
        ImmutableMap<String, Integer> peopleMaps = ImmutableMap.of("yzx", 18, "feng", 16);
        System.out.println(names);
        System.out.println(peopleMaps);
    }
}
