package com.young.pattern.observer;

/**
 * @author yzx
 * create_time 2020/9/4
 */
public class Main {
    public static void main(String[] args) {
        Subject subject = new Subject();
        BinaryObserver binaryObserver = new BinaryObserver(subject);
        OctalObserver octalObserver = new OctalObserver(subject);
        subject.setState(1);
    }
}
