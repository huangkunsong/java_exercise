package com.hks.exercise.designPattern.abstractFactory;

import com.hks.exercise.designPattern.abstractFactory.entity.CPU;
import com.hks.exercise.designPattern.abstractFactory.entity.IntelCpu;
import com.hks.exercise.designPattern.abstractFactory.entity.IntelMainboard;
import com.hks.exercise.designPattern.abstractFactory.entity.Mainboard;

public class AmdFactory implements AbstractFactory {

    @Override
    public CPU createCpu() {
        return new IntelCpu(938);
    }

    @Override
    public Mainboard createMainboard() {
        return new IntelMainboard(938);
    }
}
