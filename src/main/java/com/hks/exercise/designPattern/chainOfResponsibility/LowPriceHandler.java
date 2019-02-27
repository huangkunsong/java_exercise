package com.hks.exercise.designPattern.chainOfResponsibility;

public class LowPriceHandler extends Handler{
    @Override
    public boolean needEcho(Request request) {
        return request.getPrice() <= 500;
    }

    @Override
    public Response echo(Request request) {
        return new Response("LowPriceHandler, price：" + request.getPrice());
    }
}
