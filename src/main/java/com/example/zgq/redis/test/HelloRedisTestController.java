package com.example.zgq.redis.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ Author     ：Zgq
 * @ Date       ：Created in 15:54 2019/2/28
 * @ Description：redis的测试控制层
 * @ Modified By：
 * @Version: $
 */

@RestController
@EnableAutoConfiguration
@RequestMapping("/redis")
public class HelloRedisTestController {

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    Logger logger = LogManager.getLogger(this.getClass());

    @RequestMapping("/index")
    public String index(){
        //保存字符串
        stringRedisTemplate.opsForValue().set("name","周国庆");
        String string=stringRedisTemplate.opsForValue().get("name");

        logger.info("redis插入的数据是："+string);
        return string;
    }

}
