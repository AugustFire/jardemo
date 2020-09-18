package com.young.pattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yzx
 * create_time 2020/9/4
 */
public class Subject {

    private final List<Observer> observers = new ArrayList<>();

    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        this.notifyAllObserver();
    }

    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    public void notifyAllObserver() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
