package com.young.pattern.observer;

/**
 * @author yzx
 * create_time 2020/9/4
 */
public class BinaryObserver extends Observer{

    public BinaryObserver(Subject subject) {
        this.subject = subject;
        this.subject.addObserver(this);
    }

    @Override
    public void update() {
        System.out.println("BinaryObserver观察到-> " + subject.getState());
    }
}
