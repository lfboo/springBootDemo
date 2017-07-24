package com.example.demo.dynamicproxy;

/**
 * @author lvfeibiao
 * @date 2017/7/9
 */
public class ProxyDemo {

    public static void main(String[] args) {
        HelloProxy helloProxy = DynamicProxy.getInstance().getProxy(HelloProxyImpl.class);
        helloProxy.say();
    }

}
