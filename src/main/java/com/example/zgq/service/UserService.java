package com.example.zgq.service;

import com.example.zgq.model.test.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.List;

/**
 * @ Author     ：Zgq
 * @ Date       ：Created in 10:11 2019/3/4
 * @ Description：service类
 * @ Modified By：
 * @Version: $
 */

public interface UserService {

    User findById(String id);

    List<User> findAll();


    User save(User User);

    void delete(String id);

    //分页
    Page<User> findAll(Pageable pageable);



    List<User> findByName(String name);

    List<User> findByNameLike(String name);

    List<User> findByIdIn(Collection<String> ids);
}
