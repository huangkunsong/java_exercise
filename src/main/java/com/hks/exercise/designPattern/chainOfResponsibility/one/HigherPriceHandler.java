package com.hks.exercise.designPattern.chainOfResponsibility.one;

public class HigherPriceHandler extends Handler{
    @Override
    public boolean needEcho(Request request, Response response) {
        return request.getPrice() <= 3000;
    }

    @Override
    public void echo(Request request, Response response) {
        response.setMsg("HigherPriceHandler, price：" + request.getPrice());
    }
}
