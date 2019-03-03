package com.hks.exercise.designPattern.visitor;

public interface IVisitor {
    void print(ProjectManager projectManager);

    void print(CommonEmployee employee);
}
