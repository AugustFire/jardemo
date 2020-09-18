package com.young.pattern.adapter.ex2;

import lombok.extern.slf4j.Slf4j;

/**
 * @author yzx
 * create_time 2020/9/4
 */

public class ChinaPowerAdapter implements DC5Adapter{

    public static final int voltage = 220;


    @Override
    public boolean support(AC ac) {
        return voltage == ac.outputAC();
    }

    @Override
    public int outputDC5V(AC ac) {
        int adapterInput = ac.outputAC();
        int adapterOutput = adapterInput / 44;
        System.out.println("使用ChinaPowerAdapter 输入" + adapterInput + "输出" + adapterOutput);
        return adapterOutput;
    }
}
