package com.hks.exercise.designPattern.chainOfResponsibility.one;

/**
 * 责任链模式是一种对象的行为模式。
 * 使多个对象都有机会处理请求,从而避免了请求的发送者和接受者直接的耦合关系。
 * 将这些对象连成一条链,并沿着这条链传递该请求,直到有对象处理它为止。
 *
 * 优点：将请求和处理者分离,添加新的处理容易。
 * 缺点：链太长会太耗时,调试不方便
 */
public class Main {
    public static void main(String[] args) {
        LowPriceHandler lowPriceHandler = new LowPriceHandler();
        MediumPriceHandler mediumPriceHandler = new MediumPriceHandler();
        HigherPriceHandler higherPriceHandler = new HigherPriceHandler();

        lowPriceHandler.setNext(mediumPriceHandler);
        mediumPriceHandler.setNext(higherPriceHandler);

        for (int i = 1; i <= 100; i++) {
            Response response = new Response();
            Request request = new Request("Product-" + i, (int)(400+Math.random()*3101));
            lowPriceHandler.process(request, response);
            System.out.println(response.getMsg());
        }
    }
}
