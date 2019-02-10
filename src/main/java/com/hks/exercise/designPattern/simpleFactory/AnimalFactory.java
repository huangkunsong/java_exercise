package com.hks.exercise.designPattern.simpleFactory;

import com.hks.exercise.designPattern.simpleFactory.entity.Animal;
import com.hks.exercise.designPattern.simpleFactory.entity.Cat;
import com.hks.exercise.designPattern.simpleFactory.entity.Dog;


public class AnimalFactory {
    public static Animal builder(String type) {
        Animal animal = null;
        switch (type) {
            case "DOG" :
                animal = new Dog();
                break;
            case "CAT" :
                animal = new Cat();
                break;
            default:
                animal = new Dog();
        }
        return animal;
    }

}
