package com.hks.exercise.designPattern.strategy;

/**
 * 策略模式：定义一组算法,将每个算法都封装起来,并使它们之间可以互换。
 * 常用于算法或多种处理纬度场景（如：登录时,按账密,按扫描二维码等）
 * 优点：
 *      1：算法自由切换
 *      2：使用策略模式可以避免使用多重条件(if-else)语句。
 *      3：扩展性号
 * 缺点：
 *      1：每一个策略就是一个类,增加类数量。
 *      2：所有的策略类都需要对外曝露。
 */
public class Main {
    public static void main(String[] args) {
        CalculateContext context = new CalculateContext(new IntermediateMemberStrategy());
        double price = 800;
        System.out.println("价格：" + context.calculate(price));

        context.setMemberStrategy(new AdvancedMemberStrategy());
        System.out.println("价格：" + context.calculate(price));

        context.setMemberStrategy(new PrimaryMemberStrategy());
        System.out.println("价格：" + context.calculate(price));
    }
}
