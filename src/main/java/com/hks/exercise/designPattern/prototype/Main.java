package com.hks.exercise.designPattern.prototype;

/**
 * 原型模式：用原型实例指定创建对象的种类,并通过拷贝这些原型创建新的对象
 * 在Java中原型模式实现非常简单,要实现拷贝的类继承Cloneable接口,重写clone方法,
 * 即可实现实例的拷贝,
 *
 * clone对象的构造函数不会被执行,因为：
 * clone方法是从内存中以二进制流的方式进行拷贝（浅拷贝）,要完成深拷贝需要将引用属性也进行clone后赋值
 * final类型的成员变量不会被拷贝
 */
public class Main {
    public static void main(String[] args) {
        Product product = new Product();
        product.setName("张三");

        Product product1 =product.clone();
        System.out.println(product1.getName());
        System.out.println(product == product1);
    }
}
