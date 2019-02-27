package com.hks.exercise.designPattern.proxy.classProxy;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class GameProxy implements MethodInterceptor{
    @Override
    public Object intercept(Object target, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("开始执行...");
        methodProxy.invokeSuper(target, objects);
        System.out.println("结束执行...");
        return target;
    }
}
