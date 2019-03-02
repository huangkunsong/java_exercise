package com.hks.exercise.designPattern.combination;

/**
 * 组合模式（合成模式）：
 *      将对象组合成树形结构以表示“部分-整体”的层次结构,使得用户对单个对象和组合对象的使用具有一致性。
 *      抽象节点：定义了叶子和树枝节点的公共方法和属性
 *      叶子节点：其下没有其他的分支,也是遍历的最小单元。
 *      树枝节点：它的作用是组合树枝节点和叶子节点形成一个树形结构。
 *
 * 使用场景：
 *      维护和展示部分-整体的关系,如：树形菜单,文件。公司员工层级
 */
public class Main {
    public static void main(String[] args) {
        CEO ceo = new CEO();
        DepartmentManager departmentManager = new DepartmentManager();
        ProjectManager projectManager = new ProjectManager();
        Employee employee = new Employee();

        ceo.addChild(departmentManager);
        departmentManager.addChild(projectManager);
        projectManager.addChild(employee);

        ceo.work();
    }
}
