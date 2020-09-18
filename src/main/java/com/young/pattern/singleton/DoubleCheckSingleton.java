package com.young.pattern.singleton;

/**
 * @author yzx
 * create_time 2020/9/1
 */
public class DoubleCheckSingleton {

    private static volatile DoubleCheckSingleton INSTANCE = null;

    private DoubleCheckSingleton() {
    }
    public static DoubleCheckSingleton getInstance() {
            if (INSTANCE == null) {
                synchronized (DoubleCheckSingleton.class) {
                    if (INSTANCE == null) {
                        INSTANCE = new DoubleCheckSingleton();
                        return INSTANCE;
                    }
                }
            }
        return INSTANCE;
    }
}
