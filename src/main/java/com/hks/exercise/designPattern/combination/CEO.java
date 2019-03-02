package com.hks.exercise.designPattern.combination;

public class CEO extends Controller {
    @Override
    public void work() {
        System.out.println("CEO定义方向,让部门经理去完成");
        super.work();
    }
}
