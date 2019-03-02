package com.example.zgq.listener.test;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @ Author     ：Zgq
 * @ Date       ：Created in 0:02 2019/3/2
 * @ Description：listener全局监听
 * @ Modified By：
 * @Version: $
 */

@WebListener
public class MyServeltContextLinster implements ServletContextListener {


    @Override
    public void contextInitialized(ServletContextEvent sce){
        System.out.printf("系统启动时加载数据库配置加入缓存中");
        System.out.printf("初始化");
        System.out.printf(sce.getServletContext().getServerInfo());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce){
        System.out.printf("销毁");
    }

}
