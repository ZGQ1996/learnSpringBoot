package com.example.zgq.service;

import com.example.zgq.model.test.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.List;

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


    User findByNameAndPassword(String name, String password);

    /**
     *  描述：通过用户名查询用户
     * @param name
     */
    User findByUserName(@Param("name") String name);
}
