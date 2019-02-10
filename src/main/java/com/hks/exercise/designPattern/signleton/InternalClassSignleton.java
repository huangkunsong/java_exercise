package com.hks.exercise.designPattern.signleton;

/**
 * 单例模式,内部类实现方式
 * 实际使用时才去加载类
 */
public class InternalClassSignleton {
    private InternalClassSignleton(){};

    private static class InternalClass {
        public static InternalClassSignleton signleton = new InternalClassSignleton();
    }

    public static InternalClassSignleton getInternalClassSignleton() {
        return InternalClass.signleton;
    }
}
