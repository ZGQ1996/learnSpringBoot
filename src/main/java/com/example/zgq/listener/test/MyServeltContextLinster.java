package com.example.zgq.listener.test;

import com.example.zgq.model.test.User;
import com.example.zgq.service.UserService;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.List;

/**
 * @ Author     ：Zgq
 * @ Date       ：Created in 0:02 2019/3/2
 * @ Description：listener全局监听
 * @ Modified By：
 * @Version: $
 */

@WebListener
public class MyServeltContextLinster implements ServletContextListener {


    @Resource
    private RedisTemplate redisTemplate;
    @Resource
    private UserService userService;

    private static final String ALL_USER = "ALL_USER_LIST";



    @Override
    public void contextInitialized(ServletContextEvent sce){
        //查询数据库所有的用户
        List<User> ayUserList =  userService.findAll();
        //清除缓存中的用户数据
        redisTemplate.delete(ALL_USER);
        //存放到redis缓存中
        redisTemplate.opsForList().leftPushAll(ALL_USER, ayUserList);
        //真实项目中需要注释掉
        List<User> queryUserList = redisTemplate.opsForList().range(ALL_USER, 0, -1);
        System.out.println("缓存中目前的用户数有：" + queryUserList.size() + " 人");
        System.out.println("ServletContext上下文初始化");
        //logger.info("ServletContext上下文初始化");
        //logger.info("缓存中目前的用户数有：" + queryUserList.size() + " 人");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce){
        System.out.printf("Linster destroyed");
    }

}
