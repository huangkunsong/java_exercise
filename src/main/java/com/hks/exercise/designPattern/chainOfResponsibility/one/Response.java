package com.hks.exercise.designPattern.chainOfResponsibility.one;

public class Response {

    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Response() {
    }

    public Response(String msg) {
        this.msg = msg;
    }
}
