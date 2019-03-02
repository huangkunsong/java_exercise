package com.hks.exercise.designPattern.combination;

public class DepartmentManager extends Controller {
    @Override
    public void work() {
        System.out.println("部门经理承接部分CEO定义的方向,让项目经理去完成");
        super.work();
    }
}
