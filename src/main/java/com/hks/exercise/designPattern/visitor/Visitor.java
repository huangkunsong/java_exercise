package com.hks.exercise.designPattern.visitor;

public class Visitor implements IVisitor {

    private void printBase(Employee employee) {
        System.out.print("Name：" + employee.getName() + ",");
        System.out.print("Age：" + employee.getAge() + ",");
    }

    @Override
    public void print(ProjectManager projectManager) {
        printBase(projectManager);
        System.out.print("业绩：" + projectManager.getPerformance()+ "\n");
    }

    @Override
    public void print(CommonEmployee employee) {
        printBase(employee);
        System.out.print("工作：" + employee.getJob() + "\n");
    }
}
