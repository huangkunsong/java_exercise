package com.hks.exercise.designPattern.chainOfResponsibility.two;

public class Response {

    private boolean success = true;

    private StringBuffer msg = new StringBuffer();

    public String getMsg() {
        return msg.toString();
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setMsg(String msg) {
        this.msg.append(msg);
        this.success = false;
    }

    public Response() {
    }
}
