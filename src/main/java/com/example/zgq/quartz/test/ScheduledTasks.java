package com.example.zgq.quartz.test;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ Author     ：Zgq
 * @ Date       ：Created in 15:10 2019/2/28
 * @ Description：定时器的第二种办法
 * @ Modified By：
 * @Version: $
 */

@Component
@Configurable
@EnableScheduling
public class ScheduledTasks {

    @Scheduled(fixedRate = 1000*30)
    public void reportCurrentTime(){
        System.out.printf("this time " + dateFormat().format(new Date()));
    }


    @Scheduled(cron = "0/5 0/1 * * * ? ")
    public void reportCurrentByCron(){
        System.out.printf("this time "+  dateFormat().format(new Date()));
    }

    private SimpleDateFormat dateFormat(){
        return new SimpleDateFormat("HH:mm:ss");
    }


}
