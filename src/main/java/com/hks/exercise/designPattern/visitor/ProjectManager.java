package com.hks.exercise.designPattern.visitor;

public class ProjectManager extends Employee {
    private String performance;

    public String getPerformance() {
        return performance;
    }

    public void setPerformance(String performance) {
        this.performance = performance;
    }

    @Override
    public void print(Visitor visitor) {
        visitor.print(this);
    }
}
