package com.hks.exercise.designPattern.signleton;
/**
 * 双重synchronized控制非空
 * volatile防止重排序
 */
public class DoubleCheckSingleton {

    private volatile static DoubleCheckSingleton single = null;

    private DoubleCheckSingleton(){}

    public static DoubleCheckSingleton getInstance() {
        if (null == single) {
            synchronized (DoubleCheckSingleton.class) {
                if (null == single) {
                    single = new DoubleCheckSingleton();
                }
            }
        }
        return single;
    }
}
