package com.example.zgq.repository.test;

import com.example.zgq.model.test.Mood;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 描述：说说repository
 * @author Ay
 * @date   2017/12/02
 */
public interface MoodRepository extends JpaRepository<Mood,String> {

}
