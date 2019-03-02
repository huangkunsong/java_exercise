package com.hks.exercise.designPattern.chainOfResponsibility.two;

import java.util.ArrayList;
import java.util.List;

public class ValidatorChain {
    List<Validator> validators = new ArrayList<>();

    boolean firstErrorBreak = true;

    public void setFirstErrorBreak(boolean firstErrorBreak) {
        this.firstErrorBreak = firstErrorBreak;
    }

    public void addValidator(Validator validator) {
        if (!validators.contains(validator)) {
            validators.add(validator);
        }
    }

    public boolean execution(Request request, Response response) {
        for (Validator validator : validators) {
            validator.exec(request, response);
            if (!response.getSuccess() && firstErrorBreak) {
                break;
            }
        }
        return response.getSuccess();
    }
}
