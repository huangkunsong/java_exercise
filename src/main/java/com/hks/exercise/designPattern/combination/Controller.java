package com.hks.exercise.designPattern.combination;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象树枝节点：包含所有的下级节点和对下级节点的管理方法,add,remove,getChild等
 */
public abstract class Controller extends Operation {
    List<Operation> employees = new ArrayList<>();

    public void addChild(Operation employee) {
        this.employees.add(employee);
    }

    public void removeChild(Operation employee) {
        this.employees.remove(employee);
    }

    public List<Operation> getChild() {
        return employees;
    }

    @Override
    public void work() {
        for (Operation child : employees) {
            child.work();
        }
    }
}
