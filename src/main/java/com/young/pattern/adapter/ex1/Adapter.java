package com.young.pattern.adapter.ex1;

/**
 * @author yzx
 * create_time 2020/9/4
 */
public class Adapter implements Target{

    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }


    @Override
    public void request() {
        adaptee.specificRequest();
    }
}
