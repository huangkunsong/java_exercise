package com.hks.exercise.designPattern.strategy;

public class PrimaryMemberStrategy implements MemberStrategy {
    @Override
    public double calculatePrice(double price) {
        System.out.println("初级会员不打折。");
        return price;
    }
}
