package com.hks.exercise.classInfo;

import java.lang.reflect.*;

public class ClassMethod {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class clazz = String.class;
        /**
         * 调用类的无参构造
         */
        System.out.println(clazz.newInstance());

        /**
         * 获取类加载器,String为bootstrap加载器加载,无法获取
         */
        System.out.println(clazz.getClassLoader());

        /**
         * 获取类的父类
         */
        System.out.println(clazz.getSuperclass());

        /**
         * 判定指定的 Class 对象是否表示一个 Java 的基类型。
         */
        System.out.println(clazz.isPrimitive());

        /**
         * instanceof 操作的动态等价方法。
         */
        System.out.println(clazz.isInstance("123"));

        /**
         * 类是否基本类型
         */
        clazz.isPrimitive();
        /**
         * 返回指定类型参数的构造函数(不包含private的)
         */
        Constructor<String> constructor = clazz.getConstructor(clazz);
        System.out.println(constructor.newInstance("123"));

        /**
         * 返回指定类型参数的构造函数(包含private的)
         */
        clazz.getDeclaredConstructor(clazz);

        /**
         * 返回该类的所有构造函数(不包含private的)
         */
        System.out.println(clazz.getConstructors());

        /**
         * 返回该类的所有构造函数(包含private的)
         */
        System.out.println(clazz.getDeclaredConstructors());

        /**
         * 获取类的注解,包括继承的
         */
        System.out.println(clazz.getAnnotations());

        /**
         * 获取类的注解,不包括继承的
         */
        clazz.getDeclaredAnnotations();

        /**
         * 判断clazz是否是参数的父类,接口或者A和B是同一个类或者接口
         */
        clazz.isAssignableFrom(String.class);

        /**
         * 对于类，为自己声明实现的所有接口，
         * 对于接口，为直接扩展的接口，不包括通过父类间接继承来的
         */
        clazz.getInterfaces();

        /**
         * 获取所有字段,不包含private
         */
        clazz.getFields();

        /**
         * 获取所有字段,包含private,不包含继承的
         */
        clazz.getDeclaredFields();

        /**
         * 获取指定字段
         */
        Field field = clazz.getField("a");
        clazz.getDeclaredField("a");

        /**
         * 为指定实例设置该字段值
         */
        field.set(new String(), "aaa");

        /**
         * 获取指定实例该字段值
         */
        field.get(new String());

        /**
         * 返回字段的class类型
         */
        field.getDeclaringClass();
        /**
         * 字段是否枚举类型
         */
        field.isEnumConstant();

        /**
         * 设置字段为可见的
         */
        field.setAccessible(true);

        /**
         * 返回该类指定方法名和参数的方法
         */
        Method method = clazz.getMethod("", String.class);
        clazz.getDeclaredMethod("");
        clazz.getMethods();
        clazz.getDeclaredMethods();

        /**
         * 执行方法
         */
        method.invoke(new String(), "1");

        /**
         * 返回方法的返回值类型
         */
        Class c = method.getReturnType();

        /**
         * 返回方法返回值类型的Type对象
         */
        Type type = method.getGenericReturnType();


        /**
         * 返回方法参数总数
         */
        method.getParameterCount();

        /**
         * 返回参数的class类型
         */
        Class[] paramsClass = method.getParameterTypes();

        /**
         * 返回参数的Type对象
         */
        method.getGenericParameterTypes();

        /**
         * 方法是否带有可变参数
         */
        method.isVarArgs();

        /**
         * 设置方法可见性
         */
        method.setAccessible(true);

        /**
         * 返回方法指定抛出的异常class
         */
        method.getExceptionTypes();

        /**
         * 返回方法的所有Annotataion,不包括继承的
         */
        method.getDeclaredAnnotations();

        /**
         * 返回方法的所有Annotataion,包括继承的
         */
        method.getAnnotations();

        /**
         * 返回方法参数的所有Annotation
         */
        method.getParameterAnnotations();

    }

}
