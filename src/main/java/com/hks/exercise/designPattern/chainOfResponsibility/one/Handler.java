package com.hks.exercise.designPattern.chainOfResponsibility.one;

public abstract class Handler {

    private Handler nextHandler;

    public void setNext(Handler handler) {
        this.nextHandler = handler;
    }

    /**
     * 模板方法模式
     * 根据链的顺序遍历,直到有符合的就执行处理返回
     * 可变形为：
     *      根据链的顺序遍历,每个链中的对象进行处理,直到有处理失败的就中断执行
     *      使用场景：一个请求要执行N个校验,每个校验可以写一个处理类,使用责任链遍历,将校验通过后的逻辑写在最后一个处理器上。
     * @param request
     * @return
     */
    public final void process(Request request, Response response) {
        if (this.needEcho(request, response)) {
            this.echo(request, response);
        } else if (null != this.nextHandler) {
            this.nextHandler.process(request, response);
        } else {
            response.setMsg("not matched, price：" + request.getPrice());
        }
    }

    public abstract boolean needEcho(Request request, Response response);

    public abstract void echo(Request request, Response response);
}
