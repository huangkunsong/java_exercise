package com.hks.exercise.designPattern.strategy;

public class IntermediateMemberStrategy implements MemberStrategy {
    @Override
    public double calculatePrice(double price) {
        System.out.println("中级会员打9折");
        return price * 0.9;
    }
}
