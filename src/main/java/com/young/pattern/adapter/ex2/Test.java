package com.young.pattern.adapter.ex2;

import com.google.common.collect.ImmutableList;

import java.util.List;

/**
 * 适配器模式重在兼容
 *
 * @author yzx
 * create_time 2020/9/4
 */
public class Test {

    private static final List<DC5Adapter> dc5Adapters = ImmutableList.of(new ChinaPowerAdapter(), new JapanPowerAdapter());


    public static DC5Adapter getAdapter(AC ac) {
        DC5Adapter dc5Adapter = null;
        for (DC5Adapter adapter : dc5Adapters) {
            if (adapter.support(ac)) {
                dc5Adapter = adapter;
                break;
            }
        }
        if (dc5Adapter == null) {
            System.out.println("--null-");
        }
        return dc5Adapter;
    }

    public static void main(String[] args) {
        AC220 ac220 = new AC220();
        DC5Adapter adapter = getAdapter(ac220);
        int i = adapter.outputDC5V(ac220);
        System.out.println(i);

    }

}
