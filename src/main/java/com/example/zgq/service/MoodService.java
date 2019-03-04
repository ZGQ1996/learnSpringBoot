package com.example.zgq.service;

import com.example.zgq.model.test.Mood;

/**
 * 描述：微信说说服务层
 * @author Ay
 * @date   2017/12/2.
 */
public interface MoodService {

    Mood save(Mood Mood);

    String asynSave(Mood Mood);

}
