package com.hks.exercise.designPattern.memento;

public class Operation implements Cloneable {

    private String state;

    private String action;

    public Operation createMemento() {
        return this.clone();
    }

    public void restoreMemento(Operation operation) {
        this.action = operation.getAction();
        this.state = operation.getState();
    }


    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    protected Operation clone() {
        try {
            return (Operation) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString() {
        return "Operation{" +
            "state='" + state + '\'' +
            ", action='" + action + '\'' +
            '}';
    }
}
