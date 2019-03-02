package com.hks.exercise.designPattern.adapter;

/**
 * 适配器模式（包装模式）
 *      将一个类的接口变换成客户端所期望的另一种接口,
 *      从而使原本因接口不匹配而无法在一起工作的两个类能够一起工作。
 * 优点：系统需要使用现有的类，而此类的接口不符合系统的需要。那么通过适配器模式就可以让这些功能得到更好的复用。
 * 缺点：过多的使用适配器，会让系统非常零乱，不易整体进行把握。
 *      比如，明明看到调用的是A接口，其实内部被适配成了B接口的实现，一个系统如果太多出现这种情况，无异于一场灾难。
 *      因此如果不是很有必要，可以不使用适配器，而是直接对系统进行重构。
 */
public class Main {
    public static void main(String[] args) {
        Target target = new Adapter();
        target.doSomething();
    }
}
