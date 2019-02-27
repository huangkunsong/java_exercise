package com.hks.exercise.designPattern.chainOfResponsibility;

public class MediumPriceHandler extends Handler{
    @Override
    public boolean needEcho(Request request) {
        return request.getPrice() <= 1500;
    }

    @Override
    public Response echo(Request request) {
        return new Response("MediumPriceHandler, price：" + request.getPrice());
    }
}
