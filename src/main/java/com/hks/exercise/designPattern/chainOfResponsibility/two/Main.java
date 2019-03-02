package com.hks.exercise.designPattern.chainOfResponsibility.two;

public class Main {
    public static void main(String[] args) {
        Request request = new Request("产品&1", -1);
        Response response = new Response();
        ValidatorChain chain = new ValidatorChain();
        chain.addValidator(new SpecialCharactersValidator());
        chain.addValidator(new PriceValidator());
        chain.setFirstErrorBreak(false);
        chain.execution(request, response);
        if (!response.getSuccess()) {
            System.out.println(response.getMsg());
        } else {
            System.out.println("Verification pass");
        }

    }
}
