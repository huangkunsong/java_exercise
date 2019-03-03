package com.hks.exercise.designPattern.bridge;

/**
 * 桥梁模式：将抽象和实现解耦,使得两者可以独立地变化。
 *          面向接口编程
 */
public class Main {
    public static void main(String[] args) {
        IReqeust requestImpl = new RequestImpl();
        Request request = new Request(requestImpl);
        request.getRequest();
    }
}
