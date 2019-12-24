package com.young.sdkdemo.concurrency.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁
 * create_time 2019/12/18
 *
 * @author yzx
 */
public class Cache {


    static Map<String, Object> map = new HashMap<>();

    static ReentrantReadWriteLock rwL = new ReentrantReadWriteLock();

    static Lock rL = rwL.readLock();

    static Lock wL = rwL.writeLock();

    public static  Object get(String key) {
        rL.lock();
        try {
            return map.get(key);
        } finally {
            rL.unlock();
        }
    }

    public static Object put(String key, Object value) {
        wL.lock();
        try {
            return map.put(key, value);
        } finally {
            wL.unlock();
        }
    }

    public static void clear() {
        wL.lock();
        try {
            map.clear();
        } finally {
            wL.unlock();
        }
    }



}
