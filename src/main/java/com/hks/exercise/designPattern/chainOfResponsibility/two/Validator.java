package com.hks.exercise.designPattern.chainOfResponsibility.two;

public interface Validator {

    boolean shouldValidate(Request request, Response response);

    void exec(Request request, Response response);
}
