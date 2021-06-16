package com.yuzh.jedis;

import redis.clients.jedis.Jedis;

public class TestList {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.1.78", 6379);
        jedis.flushDB();
        System.out.println("=============添加一个List==============");
        jedis.lpush("collections", "ArrayList", "Vector", "Stack", "HashMap", "WeakHashMap", "LinkList","HashMap","HashMap");
        jedis.lpush("collections", "HashSet");
        jedis.lpush("collections", "TreeSet");
        jedis.lpush("collections", "TreeMap");
        System.out.println("Collections的内容："+jedis.lrange("collections",0,-1));
        System.out.println("collections区间0-3的元素："+jedis.lrange("collections",0,3));
        System.out.println("===================================");
        /*删除列表中指定的值，第二个位删除的个数，后添加添加进去的值会先被删除，类似于出栈*/
        System.out.println("删除指定元素的个数："+jedis.lrem("collections",2,"HashMap"));
        System.out.println("collection的类容："+jedis.lrange("collections",0,-1));
        System.out.println("删除下表区间0-3之外的元素："+jedis.ltrim("collections",0,3));
        System.out.println("collections的类容："+jedis.lrange("collections",0,-1));
        System.out.println("collections列表出栈(右端)："+jedis.rpop("collections"));
        System.out.println("collections的内容："+jedis.lrange("collections",0,-1));
        System.out.println("修改指定下标为1的内容："+jedis.lset("collections",0,"LinkHashMap"));
        System.out.println("collections的内容："+jedis.lrange("collections",0,-1));
        System.out.println("collections的长度："+jedis.llen("collections"));
        System.out.println("获取collections下标位2的元素："+jedis.lindex("collections",2));

    }
}
