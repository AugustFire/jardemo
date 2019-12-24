package com.young.sdkdemo.concurrency.lock;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 阻塞有界队列
 *
 * @author yzx
 * create_time 2019/12/18
 */
public class BoundQueue<T> {

    private Object[] items;

    private int addIndex, removeIndex, count;

    private Lock lock = new ReentrantLock();

    private Condition notEmpty = lock.newCondition();

    private Condition notFull = lock.newCondition();

    public BoundQueue(int size) {
        items = new Object[size];
    }

    public void add(T t) throws InterruptedException {
        lock.lock();
        try {
            while (count == items.length) {
                notFull.await();
            }
                items[addIndex] =t;
                if (++addIndex == items.length) {
                    addIndex = 0;
                }
                ++count;
                notEmpty.signal();

        }finally {
            lock.unlock();
        }
    }

    public T remove() throws InterruptedException {

        lock.lock();

        try {
            while (count == 0) {
                notEmpty.await();
            }
            Object item = items[removeIndex];
            if (++removeIndex == items.length) {
                removeIndex = 0;
            }
            --count;
            notFull.signal();
            return (T) item;
        } finally {
            lock.unlock();
        }
    }


}
