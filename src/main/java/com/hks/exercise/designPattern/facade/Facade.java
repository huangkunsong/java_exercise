package com.hks.exercise.designPattern.facade;

public class Facade {
    private ClassA classA = new ClassA();
    private ClassB classB = new ClassB();
    private ClassC classC = new ClassC();

    public void methodA() {
        this.classA.methodA();
    }

    public void methodB() {
        this.classB.methodB();
    }

    public void methodC() {
        this.classC.methodC();
    }

}
