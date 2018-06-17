package com.hks.exercise.designPattern;
/**
 * 双重synchronized控制非空
 * volatile防止重排序
 */
public class Single {

    private volatile static Single single = null;

    private Single(){}

    public static Single getInstance() {
        if (null == single) {
            synchronized (single) {
                if (null == single) {
                    single = new Single();
                }
            }
        }
        return single;
    }
}
