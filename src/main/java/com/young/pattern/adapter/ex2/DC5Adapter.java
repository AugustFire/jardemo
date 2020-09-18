package com.young.pattern.adapter.ex2;

/**
 * @author yzx
 * create_time 2020/9/4
 */
public interface DC5Adapter {
    boolean support(AC ac);

    int outputDC5V(AC ac);

}
