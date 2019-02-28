package com.example.zgq.quartz.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @ Author     ：Zgq
 * @ Date       ：Created in 10:16 2019/2/28
 * @ Description：测试定时器类
 * @ Modified By：
 * @Version: $
 */
public class TestTask {

    //日志对象
    private static final Logger LOG = LogManager.getLogger(TestTask.class);

    public void run(){
        if (LOG.isInfoEnabled()){
            LOG.info("测试线程开始了");
        }

        System.out.printf("quartz run ....");
    }
}
