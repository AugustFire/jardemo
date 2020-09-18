package com.young.pattern.singleton;

/**
 * @author yzx
 * create_time 2020/9/1
 */
public class StaticBlockSingleton {

    private StaticBlockSingleton() {
    }
    public static StaticBlockSingleton getInstance() {
        return singletonHolder.INSTANCE;
    }

    private static class singletonHolder {
        private static final StaticBlockSingleton INSTANCE = new StaticBlockSingleton();
    }
}
