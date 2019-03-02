package com.hks.exercise.designPattern.iterator;

import java.util.*;

/**
 * 迭代器模式：
 *      提供一个方法访问容器中的每一个元素,而又不需要曝露该对象的内部细节
 *      一个已经没落的模式,Java的List,Set等都实现了JDK迭代器,不需要实现。
 * Java中迭代器遍历时,不可以直接删除容器中的元素,会抛出并发操作异常,只能通过迭代器的remove来删除元素。
 */
public class Main {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("aaa");
        strings.add("bbb");
        strings.add("ccc");
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            String str = iterator.next();
            System.out.println(str);
        }

        Map<String, String> map = new HashMap<>();
        map.put("a", "aa");
        map.put("b", "bb");
        map.put("c", "cc");
        Iterator<Map.Entry<String, String>> mapIterator = map.entrySet().iterator();
        while (mapIterator.hasNext()) {
            Map.Entry<String, String> item = mapIterator.next();
            System.out.println(item.getValue());
        }
        for (Map.Entry<String,String> item : map.entrySet()){
            System.out.println(item.getValue());
        }
    }
}
