package com.young.pattern.adapter.ex2;

/**
 * @author yzx
 * create_time 2020/9/4
 */
public class AC220 implements AC{

    public final int output = 220;
    @Override
    public int outputAC() {
        return output;
    }
}
