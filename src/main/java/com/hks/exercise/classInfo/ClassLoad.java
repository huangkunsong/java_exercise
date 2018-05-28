package com.hks.exercise.classInfo;

/**
 * 类加载器
 *  委托机制：
 *      一个类加载和初始化,会先委托给父类加载器，如：
 *          ThreadInfo.class 先委托给Extension,在委托给Bootstrap,
 *          Bootstrap找不到类,会回到Extension去加载,
 *          找不到在回到System加载，在找不到就报ClassNotFoundException
 *  可见性：
 *      子类可以看到父类加载过的类,反之则不行。
 *  单一性机制：
 *      根据这个机制，父加载器加载过的类不能被子加载器加载第二次。
 * 三种默认加载器：
 *  Bootstrap类加载器(使用C/C++编写,封装到JVM内核中) 获取不到的
 *      负责加载 JRE/lib/rt.jar,如String,Integer,Map
 *      最顶层的类加载器,没有父类加载器。
 *  Extension(ExtClassLoader)类加载器
 *      负责加载 JRE/lib/ext
 *  System(AppClassLoader)
 *      classpath指定的所有jar或目录
 *
 *  自定义类加载器：
 *      继承ClassLoader实现和加载一个类的执行顺序：
 *          loadClass->findClass->defineClass
 *  自定义类加载器的父类都是AppClassLoader
 *
 *  Java文件要编译成class字节码文件后才可以被JVM加载。
 *
 *  类的装载步骤：
 *      1、加载：
 *          jvm把class文件字节码加载到内存中,
 *          并将这些静态数据装换成运行时数据区中方法区的类型数据,
 *          在运行时数据区堆中生成一个代表这个类
 *      2、链接：
 *          校验：检查加载的class文件的正确性和安全性
 *          准备：为类的静态变量分配内存，并将其初始化为默认值；
 *          解析：jvm将常量池内的符号引用转换为直接引用
 *      3、初始化：
 *          为类的静态变量赋予正确的初始值,和执行静态代码块
 *
 */
public class ClassLoad {
    public static void main(String[] args) {
        /**
         * 获取本线程类加载器,一般都为AppClassLoader
         * setContextClassLoader,设置本线程类加载器
         */
        System.out.println(Thread.currentThread().getContextClassLoader());

        /**
         * 获取不到Bootstrap类加载器
         */
        System.out.println(System.class.getClassLoader());

        /**
         * 获取classLoad的几种方式。
         * 获取都是AppClassLoader
         */
        System.out.println(ClassLoader.getSystemClassLoader());
        System.out.println(ClassLoad.class.getClassLoader());


        /**
         * 类加载方法
         */
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        try {
            /**
             * 得到的class是还没有链接的
             * 类的变量赋值和静态代码块都没进行
             */
            loader.loadClass("com.hks.exercise.classInfo.ClassLoad");

            /**
             * 得到的class是已经初始化完成的,已经执行的类的静态块
             */
            Class.forName("com.hks.exercise.classInfo.ClassLoad");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
