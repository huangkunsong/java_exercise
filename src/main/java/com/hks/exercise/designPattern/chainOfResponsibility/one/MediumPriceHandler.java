package com.hks.exercise.designPattern.chainOfResponsibility.one;

public class MediumPriceHandler extends Handler{
    @Override
    public boolean needEcho(Request request, Response response) {
        return request.getPrice() <= 1500;
    }

    @Override
    public void echo(Request request, Response response) {
        response.setMsg("MediumPriceHandler, price：" + request.getPrice());
    }
}
