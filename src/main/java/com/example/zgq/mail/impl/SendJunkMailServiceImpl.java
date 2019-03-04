package com.example.zgq.mail.impl;

import com.example.zgq.mail.SendJunkMailService;
import com.example.zgq.model.test.User;
import com.example.zgq.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import java.util.List;

/**
 * 描述：发送用户邮件服务
 * @author Ay
 * @date   2017/11/19
 */
@Service
public class SendJunkMailServiceImpl implements SendJunkMailService {

    @Autowired
    JavaMailSender mailSender;
    @Resource
    private UserService userService;

    @Value("${spring.mail.username}")
    private String from;
    static final Logger logger = LogManager.getLogger(SendJunkMailServiceImpl.class);

    @Override
    public boolean sendJunkMail(List<User> UserList) {

        try{
            if(UserList == null || UserList.size() <= 0 ){ return Boolean.FALSE;}
            for(User User: UserList){
                MimeMessage mimeMessage = this.mailSender.createMimeMessage();
                MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
                message.setFrom(from);
                message.setSubject("地瓜今日特卖");
                message.setTo("al_test@163.com");
                message.setText(User.getName() + " ,你知道么？厦门地瓜今日特卖，一斤只要9元");
                this.mailSender.send(mimeMessage);
            }
        }catch(Exception ex){
            logger.error("sendJunkMail error and User=%s", UserList, ex);
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}
