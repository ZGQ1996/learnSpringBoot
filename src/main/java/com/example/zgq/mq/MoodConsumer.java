package com.example.zgq.mq;

import com.example.zgq.model.test.Mood;
import com.example.zgq.service.MoodService;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 消费者
 * @author Zgq
 * @date   2017/11/30
 */
@Component
public class MoodConsumer {

    @JmsListener(destination = "zgq.queue")
    public void receiveQueue(String text) {
        System.out.println("用户发表说说【" + text + "】成功");
    }

    @Resource
    private MoodService moodService;

    @JmsListener(destination = "zgq.queue.asyn.save")
    public void receiveQueue(Mood Mood){
        moodService.save(Mood);
    }
}
