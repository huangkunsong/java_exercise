package com.hks.exercise.designPattern.flyweight;

/**
 * 享元模式：使用共享对象可有效地支持大量的细粒度的对象
 *          享元模式采用一个共享来避免大量拥有相同内容对象的开销
 *          https://blog.csdn.net/wwwdc1012/article/details/82833965
 * 使用场景：对象池技术（commons-pool）
 */
public class Main {
    public static void main(String[] args) {
        Resource resourceA = ResourceFactory.getResource("a");
        resourceA.setCode("aFile");
        resourceA.setContent("aContent");
        resourceA.print("aFileName");

        Resource resourceB = ResourceFactory.getResource("b");
        resourceB.setCode("bFile");
        resourceB.setContent("bContent");
        resourceB.print("bFileName");

        Resource resource = ResourceFactory.getResource("a");
        resource.print("cFileName");
    }
}
