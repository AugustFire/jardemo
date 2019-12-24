package com.young.sdkdemo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * create_time 2019/11/13
 *
 * @author yzx
 */
public class ProxyCar implements InvocationHandler {

    private Object target;

    public ProxyCar(Object target) {
        this.target = target;
    }

    private void aopMethod() {
        System.out.println("--------before--------");
    }

    @SuppressWarnings("all")
    public <T> T getProxy() {
        return  (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        aopMethod();
        return method.invoke(target, args);
    }
}
