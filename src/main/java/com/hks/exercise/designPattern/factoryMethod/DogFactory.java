package com.hks.exercise.designPattern.factoryMethod;

import com.hks.exercise.designPattern.factoryMethod.entity.HuskyDog;
import com.hks.exercise.designPattern.factoryMethod.entity.TeddyDog;
import com.hks.exercise.designPattern.factoryMethod.entity.Dog;

public class DogFactory implements AnimalFactory {
    @Override
    public Dog build(String type) {
        Dog dog = null;
        switch (type.toUpperCase()) {
            case "HUSKY":
                dog = new HuskyDog();
                break;
            case "TEDDY":
                dog = new TeddyDog();
                break;
            default:
                dog = null;
        }
        return dog;
    }
}
