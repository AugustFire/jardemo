package com.young.sdkdemo.proxy;

import org.junit.Test;

/**
 * create_time 2019/11/13
 *
 * @author yzx
 */
public class ProxyTest {


    @Test
    public void test01() {

        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        SubCar subCar = new SubCar();
        ProxyCar proxyCar = new ProxyCar(subCar);
        Car proxy = proxyCar.getProxy();
        proxy.sayHello();


    }
}
