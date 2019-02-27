package com.hks.exercise.designPattern.proxy.interfaceProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyInterface implements InvocationHandler{

    private IGamePlayer gamePlayer;

    public ProxyInterface(IGamePlayer gamePlayer) {
        this.gamePlayer = gamePlayer;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开始执行...");
        Object result = method.invoke(this.gamePlayer, args);
        System.out.println("结束执行...");
        return result;
    }
}
