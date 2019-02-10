package com.hks.exercise.designPattern.factoryMethod;

import com.hks.exercise.designPattern.factoryMethod.entity.Animal;

public interface AnimalFactory {
    Animal build(String type);
}
