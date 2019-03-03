package com.hks.exercise.designPattern.flyweight;

import java.util.HashMap;

/**
 * 享元工厂
 */
public class ResourceFactory {
    //定义一个HashMap用于存储享元对象，实现享元池
    private static HashMap<String, Resource> resources = new HashMap();

    public static Resource getResource(String key){
        //如果对象存在，则直接从享元池获取
        if(resources.containsKey(key)){
            return resources.get(key);
        }
        //如果对象不存在，先创建一个新的对象添加到享元池中，然后返回
        else {
            Resource resource = new Resource();
            resources.put(key, resource);
            return resource;
        }
    }
}
