package com.hks.exercise.designPattern.facade;

/**
 * 门面模式（外观模式）
 *      要求一个子系统的外部与其内部的通信必须通过一个统一的对象进行。
 *      门面模式提供一个高层次的接口,使得子系统更易于使用。
 *      外面使用不需要知道内部复杂的逻辑,只要通过facade类调用即可
 *      Facade不应该包含业务逻辑,只是负责将外部请求委派内部类完成
 */
public class Main {

    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.methodA();
        facade.methodB();
        facade.methodC();
    }
}
