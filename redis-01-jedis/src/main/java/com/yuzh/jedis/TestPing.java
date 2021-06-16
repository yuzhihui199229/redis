package com.yuzh.jedis;

import redis.clients.jedis.Jedis;

public class TestPing {
    public static void main(String[] args) {
        //1、new Jedis对象
        Jedis jedis = new Jedis("192.168.1.78", 6379);
        jedis.set("j", "1643426");
        System.out.println(jedis.exists("j"));
        System.out.println(jedis.del("j"));

        System.out.println(jedis.get("j"));
        System.out.println(jedis.ping());
    }
}
