package com.hks.exercise.designPattern.combination;
/**
 * 抽象构件角色
 *      用来给参与组合模式的对象定义公共的接口及默认行为。
 * parent：用于可以从底层向上遍历
 * order：用于同级中实现排序功能
 * level：用于遍历某级节点时使用
 */
public abstract class Operation {

    private Operation parent;

    private int order = 0;

    private int level = 0;

    public void setOrder(int order) {
        this.order = order;
    }

    public void setParent(Operation component) {
        this.parent = component;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public abstract void work();
}
