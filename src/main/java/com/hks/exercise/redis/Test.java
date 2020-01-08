package com.hks.exercise.redis;

import redis.clients.jedis.Jedis;

public class Test {

    public void single() {
        Jedis jedis = new Jedis("192.168.1.102", 6380);
        jedis.auth("qwerasd");
        jedis.set("asdasdq", "晚点我");
        String value = jedis.get("asdasdq");
        System.out.println(value);
    }


}
