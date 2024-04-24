package com.mjq.bigevent;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
public class RedisTest {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    public void testSetValue(){

        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        valueOperations.set("name", "mjq");
    }

    @Test
    public void testGetValue(){
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        String s  = valueOperations.get("name");
        System.out.println(s);
    }
}
