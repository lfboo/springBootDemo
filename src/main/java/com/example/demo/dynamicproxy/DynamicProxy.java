package com.example.demo.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author lvfeibiao
 * @date 2017/7/9
 */
public class DynamicProxy implements InvocationHandler {
    private Object target;

    private static DynamicProxy INSTANCE = new DynamicProxy();

    public static DynamicProxy getInstance() {
        return INSTANCE;
    }

    public <T> T getProxy(Class<T> tClass) {
        try {
            this.target = tClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return (T) Proxy.newProxyInstance(tClass.getClassLoader(), tClass.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(target, args);
    }
}
