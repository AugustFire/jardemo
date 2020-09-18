package com.young.pattern.observer;

/**
 * @author yzx
 * create_time 2020/9/4
 */
public abstract class Observer {

    protected Subject subject;

    public abstract void update();
}
