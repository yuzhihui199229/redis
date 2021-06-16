package com.yuzh.jedis;

import redis.clients.jedis.Jedis;

public class TestString {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.1.78", 6379);
        jedis.flushDB();
        System.out.println("==============增加数据===============");
        System.out.println(jedis.set("key1", "value1"));
        System.out.println(jedis.set("key2","value2"));
        System.out.println(jedis.set("key3","value3"));
        System.out.println(jedis.set("key4","value4"));
        System.out.println("删除键key2"+jedis.del("key2"));
        System.out.println("获取键key2"+jedis.get("key2"));
        System.out.println("获取key1"+jedis.get("key1"));
        System.out.println("在key3后面加入值"+jedis.append("key3","end"));
        System.out.println("获取key3的值"+jedis.get("key3"));
        System.out.println("增加多个键值对"+jedis.mset("key01","value01","key02","value02","key03","value03","key04","value04"));
        System.out.println("获取多个键值对："+jedis.mget("key01","key02"));
        System.out.println("获取多个键值对："+jedis.mget("key01","key02","key03"));

        jedis.flushDB();
        System.out.println("新增键值对防止覆盖原来的值");
        System.out.println(jedis.setnx("key1","value1"));
        System.out.println(jedis.setnx("key2","value2"));
        System.out.println(jedis.setnx("key2","value2-new"));
        System.out.println(jedis.get("key1"));
        System.out.println(jedis.get("key2"));


    }
}
