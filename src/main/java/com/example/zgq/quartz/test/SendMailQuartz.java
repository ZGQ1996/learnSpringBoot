package com.example.zgq.quartz.test;
import com.example.zgq.mail.SendJunkMailService;
import com.example.zgq.model.test.User;
import com.example.zgq.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 描述：定时器类
 * @author Ay
 * @date   2017/11/18
 */
@Component
@Configurable
@EnableScheduling
public class SendMailQuartz {

    //日志对象
    private static final Logger logger = LogManager.getLogger(SendMailQuartz.class);

    @Resource
    private SendJunkMailService sendJunkMailService;
    @Resource
    private UserService userService;

    @Resource
    private JavaMailSender mailSender;


    //每5秒执行一次
    @Scheduled(cron = "0 0 0-2 * * ? ")
    public void reportCurrentByCron(){
        List<User> userList = userService.findAll();
        if (userList == null || userList.size() <= 0) {return;}
        //发送邮件
        sendJunkMailService.sendJunkMail(userList);
        logger.info("定时器运行了!!!");
    }





}
