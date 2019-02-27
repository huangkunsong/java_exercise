package com.hks.exercise.designPattern.chainOfResponsibility;

public class HigherPriceHandler extends Handler{
    @Override
    public boolean needEcho(Request request) {
        return request.getPrice() <= 3000;
    }

    @Override
    public Response echo(Request request) {
        return new Response("HigherPriceHandler, price：" + request.getPrice());
    }
}
