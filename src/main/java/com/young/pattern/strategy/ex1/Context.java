package com.young.pattern.strategy.ex1;

/**
 * @author yzx
 * create_time 2020/9/18
 */
public class Context {

    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2) {
        return this.strategy.doOperation(num1, num2);
    }
}
