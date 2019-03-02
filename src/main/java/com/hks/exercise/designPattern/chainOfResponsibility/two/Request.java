package com.hks.exercise.designPattern.chainOfResponsibility.two;

public class Request {

    private String name;
    private int price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Request(String name, int price) {
        this.name = name;
        this.price = price;
    }
}
