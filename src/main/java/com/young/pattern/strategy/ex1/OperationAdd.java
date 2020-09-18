package com.young.pattern.strategy.ex1;

/**
 * @author yzx
 * create_time 2020/9/18
 */
public class OperationAdd implements Strategy{
    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}
