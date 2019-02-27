package com.hks.exercise.designPattern.chainOfResponsibility;

/**
 * 责任链模式是一种对象的行为模式。
 * 使多个对象都有机会处理请求,从而避免了请求的发送者和接受者直接的耦合关系。
 * 将这些对象连成一条链,并沿着这条链传递该请求,直到有对象处理它为止。
 */
public class Main {
    public static void main(String[] args) {
        LowPriceHandler lowPriceHandler = new LowPriceHandler();
        MediumPriceHandler mediumPriceHandler = new MediumPriceHandler();
        HigherPriceHandler higherPriceHandler = new HigherPriceHandler();

        lowPriceHandler.setNext(mediumPriceHandler);
        mediumPriceHandler.setNext(higherPriceHandler);

        for (int i = 1; i <= 100; i++) {
            Request request = new Request("Product-" + i, (int)(400+Math.random()*3101));
            Response response = lowPriceHandler.process(request);
            System.out.println(response.getMsg());
        }
    }
}
