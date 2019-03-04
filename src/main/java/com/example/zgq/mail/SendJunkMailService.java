package com.example.zgq.mail;

import com.example.zgq.model.test.User;

import java.util.List;

/**
 * 描述：发送用户邮件服务
 * @author zgq
 * @date   2017/11/19
 */
public interface SendJunkMailService {

    boolean sendJunkMail(List<User> User);
}
