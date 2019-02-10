package com.hks.exercise.designPattern.signleton;

/**
 * 单例类只能有一个实例。
 * 单例类必须自己创建自己的唯一实例。
 * 单例类必须给所有其他对象提供这一实例。
 */
public class Main {
    public static void main(String[] args) {
        DoubleCheckSingleton doubleCheckSingleton1 = DoubleCheckSingleton.getInstance();
        DoubleCheckSingleton doubleCheckSingleton2 = DoubleCheckSingleton.getInstance();
        System.out.println(doubleCheckSingleton1 == doubleCheckSingleton2);

        InternalClassSignleton internalClassSignleton1 = InternalClassSignleton.getInternalClassSignleton();
        InternalClassSignleton internalClassSignleton2 = InternalClassSignleton.getInternalClassSignleton();
        System.out.println(internalClassSignleton1 == internalClassSignleton2);

    }
}
