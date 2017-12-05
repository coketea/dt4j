package com.coketea.dt.coordinator;

import com.coketea.dt.model.DTTransactionGroup;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTests {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String, DTTransactionGroup> redisTemplate;


    //@Test
    public void testString() throws Exception {

        // 保存字符串
        stringRedisTemplate.opsForValue().set("aaa", "111");
        Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));

    }

    //@Test
    public void testObject() throws Exception {
        // 保存对象
        DTTransactionGroup transactionGroup = new DTTransactionGroup();
        transactionGroup.setGroupId("1");
        redisTemplate.opsForValue().set(transactionGroup.getGroupId(), transactionGroup);

        transactionGroup = new DTTransactionGroup();
        transactionGroup.setGroupId("2");
        redisTemplate.opsForValue().set(transactionGroup.getGroupId(), transactionGroup);

        transactionGroup = new DTTransactionGroup();
        transactionGroup.setGroupId("3");
        redisTemplate.opsForValue().set(transactionGroup.getGroupId(), transactionGroup);

        Assert.assertEquals("1", redisTemplate.opsForValue().get("1").getGroupId());
        Assert.assertEquals("2", redisTemplate.opsForValue().get("2").getGroupId());
        Assert.assertEquals("3", redisTemplate.opsForValue().get("3").getGroupId());
    }
}
