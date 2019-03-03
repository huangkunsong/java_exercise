package com.hks.exercise.designPattern.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * 访问者模式：
 *      目的是封装一些施加于某种数据结构元素之上的操作。
 *      一旦这些操作需要修改的话，接受这个操作的数据结构则可以保持不变。
 *      就是提供一个公共类,类内部有一些公共方法,方法根据类型重载多种展示纬度,
 *      根据参数的类型有不同的展示方式。
 * 使用场景：一组同类型的对象同一个操作,根据实际类型的不同有不同的展示纬度时
 */
public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        ProjectManager projectManager = new ProjectManager();
        projectManager.setName("张三");
        projectManager.setAge(40);
        projectManager.setPerformance("S");

        CommonEmployee commonEmployee = new CommonEmployee();
        commonEmployee.setName("李四");
        commonEmployee.setAge(30);
        commonEmployee.setJob("开发");

        employees.add(projectManager);
        employees.add(commonEmployee);

        for (Employee employee : employees) {
            employee.print(new Visitor());
        }
    }
}
