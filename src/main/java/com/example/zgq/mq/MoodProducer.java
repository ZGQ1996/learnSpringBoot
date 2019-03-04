package com.example.zgq.mq;

import com.example.zgq.model.test.Mood;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;

/**
 * 生产者
 * @author Ay
 * @date 2017/11/30
 */
@Service
public class MoodProducer {

    @Resource
    private JmsMessagingTemplate jmsMessagingTemplate;

    public void sendMessage(Destination destination, final String message) {
        jmsMessagingTemplate.convertAndSend(destination, message);
    }

    public void sendMessage(Destination destination, final Mood Mood) {
        jmsMessagingTemplate.convertAndSend(destination, Mood);
    }
}
