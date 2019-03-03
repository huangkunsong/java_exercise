package com.hks.exercise.designPattern.bridge;

public abstract class AbstractionReqeust {
    private IReqeust reqeust;

    public AbstractionReqeust(IReqeust reqeust) {
        this.reqeust = reqeust;
    }

    public void getRequest() {
        this.reqeust.doGet();
    }

    public void postRequest() {
        this.reqeust.doPost();
    }
}
