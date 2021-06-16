package com.yuzh.redis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yuzh.redis.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
public class RedisSpringBootTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void contextLoad(){
        //RedisTemplate  opsForValue 操作字符串，类似String类型
        //opsForList 操作List类型
        //opsForSet
        //opsForHash
        //opsForZset
        //opsForGeo
        //opsForHyperLoglog

        //除了基本 的操作，我们场用的方法都可以直接通过RedisTemplate操作，比如事务，

        //获取Redis的连接对象
        RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
        connection.flushDb();
        connection.flushAll();
        redisTemplate.opsForValue().set("mykey","余志辉");
        System.out.println(redisTemplate.opsForValue().get("mykey"));
//        redisTemplate.opsForList().set("myList",0l,"listValue");
        //默认的序列化方式是jdk序列化，我们可能会使用接送来序列化，

    }

    @Test
    void testSer() {
        //真是的开发一般都使用json来传递对象
        //直接传递一个对象会报错误
        User user = new User("yuzh", 3);
        String s = null;
        try {
            s = new ObjectMapper().writeValueAsString(user);
            redisTemplate.opsForValue().set("user",user);
            System.out.println(redisTemplate.opsForValue().get("user"));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
