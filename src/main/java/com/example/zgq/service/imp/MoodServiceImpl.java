package com.example.zgq.service.imp;

import com.example.zgq.model.test.Mood;
import com.example.zgq.mq.MoodProducer;
import com.example.zgq.repository.test.MoodRepository;
import com.example.zgq.service.MoodService;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;

/**
 * 描述：微信说说服务层
 * @author Ay
 * @date   2017/12/2
 */
@Service
public class MoodServiceImpl implements MoodService {

    @Resource
    private MoodRepository MoodRepository;

    @Override
    public Mood save(Mood Mood) {
        return MoodRepository.save(Mood);
    }


    //队列
    private static Destination destination = new ActiveMQQueue("zgq.queue.asyn.save");

    @Resource
    private MoodProducer moodProducer;


    @Override
    public String asynSave(Mood Mood){
        //往队列zgq.queue.asyn.save推送消息，消息内容为说说实体
        moodProducer.sendMessage(destination, Mood);
        return "success";
    }
}
