package com.hks.exercise.map;

import java.util.HashMap;
import java.util.Map;

public class MapMethod {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        /**
         * a不存在时才put
         */
        map.putIfAbsent("a", "b");

        boolean hasKey = map.containsKey("a");
        boolean hasValue = map.containsValue("a");

        map.getOrDefault("a", "cc");
        /**
         * 如果存在key=c,则进行运算a=key,b=value
         * 返回key的新值
         */
        map.compute("a", (a, b) -> "d");
        System.out.println(map.get("a"));

        /**
         * 不存在key=d,进行运算添加
         */
        map.computeIfAbsent("d", (a) -> {
            return "DDD";
        });
        System.out.println(map.get("d"));

        /**
         * 存在key=e,则进行运算a=oldvalue,b=newvalue
         * 不存在key=e,则进行put
         */
        map.merge("e", "a", (a, b) -> {
           return a +b;
        });
        System.out.println(map.get("dddd"));
    }
}
