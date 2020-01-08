package com.hks.exercise.redis;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

class RedisTest {

    @org.junit.jupiter.api.Test
    @DisplayName("单节点测试")
    public void single() {
        Jedis jedis = new Jedis("192.168.1.102", 6380);
        jedis.auth("qwerasd");
        jedis.set("asdasdq", "晚点我");
        String value = jedis.get("asdasdq");
        System.out.println(value);
    }

    @org.junit.jupiter.api.Test
    @DisplayName("集群测试")
    public void cluster() {
        Set<HostAndPort> set = new HashSet<>();
        set.add(new HostAndPort("192.168.1.104", 7001));
        set.add(new HostAndPort("192.168.1.104", 7002));
        set.add(new HostAndPort("192.168.1.104", 7003));
        set.add(new HostAndPort("192.168.1.104", 7004));
        set.add(new HostAndPort("192.168.1.104", 7005));
        set.add(new HostAndPort("192.168.1.104", 7002));
        // Jedis连接池配置
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        // 最大空闲连接数, 默认8个
        jedisPoolConfig.setMaxIdle(100);
        // 最大连接数, 默认8个
        jedisPoolConfig.setMaxTotal(500);
        //最小空闲连接数, 默认0
        jedisPoolConfig.setMinIdle(0);
        // 获取连接时的最大等待毫秒数(如果设置为阻塞时BlockWhenExhausted),如果超时就抛异常, 小于零:阻塞不确定的时间,  默认-1
        jedisPoolConfig.setMaxWaitMillis(2000); // 设置2秒
        //对拿到的connection进行validateObject校验
        jedisPoolConfig.setTestOnBorrow(true);
        JedisCluster jedisCluster = new JedisCluster(set,
            1000,
            1000, 1,
            jedisPoolConfig);
        jedisCluster.set("asdasdasd", "我我我我");
        System.out.println(jedisCluster.get("asdasdasd"));
    }
}