package com.hks.exercise.designPattern.bridge;

public class RequestImpl implements IReqeust {
    @Override
    public void doGet() {
        System.out.println("GET RequestImpl");
    }

    @Override
    public void doPost() {
        System.out.println("POST RequestImpl");
    }
}
