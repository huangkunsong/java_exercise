package com.hks.exercise.designPattern.chainOfResponsibility.two;

public class PriceValidator implements Validator{
    @Override
    public boolean shouldValidate(Request request, Response response) {
        return true;
    }

    @Override
    public void exec(Request request, Response response) {
        if (request.getPrice() < 0 || request.getPrice() > 100) {
            response.setMsg("Illegal Amount.");
        }
    }
}
