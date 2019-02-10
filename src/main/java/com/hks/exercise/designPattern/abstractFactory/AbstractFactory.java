package com.hks.exercise.designPattern.abstractFactory;

import com.hks.exercise.designPattern.abstractFactory.entity.CPU;
import com.hks.exercise.designPattern.abstractFactory.entity.Mainboard;

public interface  AbstractFactory {
    /**
     * 创建CPU对象
     * @return CPU对象
     */
    CPU createCpu();

    /**
     * 创建主板对象
     * @return 主板对象
     */
    Mainboard createMainboard();
}
