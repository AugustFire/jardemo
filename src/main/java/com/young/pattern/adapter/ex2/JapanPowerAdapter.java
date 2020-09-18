package com.young.pattern.adapter.ex2;

/**
 * @author yzx
 * create_time 2020/9/4
 */
public class JapanPowerAdapter implements DC5Adapter{
    public static final int voltage = 110;


    @Override
    public boolean support(AC ac) {
        return voltage == ac.outputAC();
    }

    @Override
    public int outputDC5V(AC ac) {
        int adapterInput = ac.outputAC();
        int adapterOutput = adapterInput / 22;
        System.out.println("使用JapanPowerAdapter 输入 " + adapterInput + "输出 " + adapterOutput);
        return adapterOutput;
    }
}
