package com.hks.exercise.designPattern.strategy;

public class CalculateContext {
    private MemberStrategy memberStrategy;

    public CalculateContext(MemberStrategy memberStrategy) {
        this.memberStrategy = memberStrategy;
    }

    public void setMemberStrategy(MemberStrategy memberStrategy) {
        this.memberStrategy = memberStrategy;
    }

    public double calculate(double price) {
        return memberStrategy.calculatePrice(price);
    }
}
