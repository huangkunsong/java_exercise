package com.hks.exercise.designPattern.factoryMethod;

import com.hks.exercise.designPattern.factoryMethod.entity.Cat;
import com.hks.exercise.designPattern.factoryMethod.entity.PersianCat;
import com.hks.exercise.designPattern.factoryMethod.entity.WildCat;

public class CatFactory implements AnimalFactory {
    @Override
    public Cat build(String type) {
        Cat cat = null;
        switch (type.toUpperCase()) {
            case "WILD":
                cat = new WildCat();
                break;
            default:
                cat = new PersianCat();
                break;
        }
        return cat;
    }
}
