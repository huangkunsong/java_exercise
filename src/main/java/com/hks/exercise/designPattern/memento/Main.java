package com.hks.exercise.designPattern.memento;

/**
 * 备忘录模式：
 *      在不破坏封装性的前提下,捕获一个对象的内部状态,并在对象之外保存这个状态。
 *      这样以后就可以将该对象恢复到原先保存的状态。
 */
public class Main {
    public static void main(String[] args) {
        Operation operation = new Operation();
        operation.setAction("aaa");
        operation.setState("aaa");
        System.out.println(operation);

        Operation cache = operation.createMemento();

        operation.setState("bbb");
        operation.setAction("bbb");
        System.out.println(operation);

        operation.restoreMemento(cache);
        System.out.println(operation);
    }
}
