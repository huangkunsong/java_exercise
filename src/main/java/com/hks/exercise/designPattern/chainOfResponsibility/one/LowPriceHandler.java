package com.hks.exercise.designPattern.chainOfResponsibility.one;

public class LowPriceHandler extends Handler{
    @Override
    public boolean needEcho(Request request, Response response) {
        return request.getPrice() <= 500;
    }

    @Override
    public void echo(Request request, Response response) {
        response.setMsg("LowPriceHandler, price：" + request.getPrice());
    }
}
