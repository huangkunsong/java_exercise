package com.hks.exercise.designPattern.chainOfResponsibility.two;

import java.util.ArrayList;
import java.util.List;

public class SpecialCharactersValidator implements Validator {

    List<String> specialCharacter = new ArrayList<String>() {{
        this.add("&");
        this.add("<");
        this.add(">");
    }};

    @Override
    public boolean shouldValidate(Request request, Response response) {
        return true;
    }

    @Override
    public void exec(Request request, Response response) {
        for (String character : specialCharacter) {
            if (request.getName().contains(character)) {
                response.setMsg("Invalid Symbol.");
            }
        }
    }
}
