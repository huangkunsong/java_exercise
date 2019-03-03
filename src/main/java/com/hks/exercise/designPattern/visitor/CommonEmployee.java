package com.hks.exercise.designPattern.visitor;

public class CommonEmployee extends Employee {
    private String job;

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public void print(Visitor visitor) {
        visitor.print(this);
    }
}
