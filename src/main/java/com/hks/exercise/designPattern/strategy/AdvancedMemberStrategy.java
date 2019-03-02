package com.hks.exercise.designPattern.strategy;

public class AdvancedMemberStrategy implements MemberStrategy{
    @Override
    public double calculatePrice(double price) {
        System.out.println("高级会员打7折");
        return price * 0.7;
    }
}
