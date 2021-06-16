package com.yuzh.jedis;

import redis.clients.jedis.Jedis;

public class TestSet {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.1.78", 6379);
        jedis.flushDB();
        System.out.println("=================向元素中添加元素（不重复）=======================");
        System.out.println(jedis.sadd("eleSet", "e1", "e2", "e3", "e4", "e5", "e6", "e0", "e8", "e7"));
        System.out.println(jedis.sadd("eleSet","e10"));
        System.out.println(jedis.sadd("eleSet","e10"));
        System.out.println("eleSet的所有元素为："+jedis.smembers("eleSet"));
        System.out.println("删除一个元素e0:"+jedis.srem("eleSet","e0"));
        System.out.println("eleSet的所有元素为："+jedis.smembers("eleSet"));
        System.out.println("删除eleSet两个元素："+jedis.srem("eleSet","e2","e1"));
        System.out.println("eleSet所包含元素的个数："+jedis.scard("eleSet"));
        System.out.println("eleSet的所有元素为："+jedis.smembers("eleSet"));
        System.out.println("随机移除eleSet中的一个元素："+jedis.spop("eleSet"));
        System.out.println("随机移除eleSet中的一个元素："+jedis.spop("eleSet"));
        System.out.println("随机移除eleSet中的一个元素："+jedis.spop("eleSet"));
        System.out.println("eleSet的所有元素为："+jedis.smembers("eleSet"));
        System.out.println("e3是否在eleSet中：" + jedis.sismember("eleSet", "e3"));
        System.out.println("e3是否在eleSet中：" + jedis.sismember("eleSet", "e2"));
        System.out.println("e3是否在eleSet中：" + jedis.sismember("eleSet", "e1"));
        System.out.println("==============================================================");
        System.out.println(jedis.sadd("eleSet1", "e1", "e2", "e3", "e4", "e5", "e6", "e0", "e8", "e7"));
        System.out.println(jedis.sadd("eleSet2", "e1", "e2", "e3", "e4", "e5", "e6"));
        System.out.println("将eleSet1中删除e1并存入eleSet3中："+jedis.smove("eleSet1","eleSet3","e1"));
        System.out.println("将eleSet1中删除e2并存入eleSet3中："+jedis.smove("eleSet1","eleSet3","e2"));
        System.out.println("eleSet2的所有元素为："+jedis.smembers("eleSet2"));
        System.out.println("eleSet3的所有元素为："+jedis.smembers("eleSet3"));

    }
}
