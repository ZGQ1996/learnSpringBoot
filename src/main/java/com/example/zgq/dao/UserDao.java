package com.example.zgq.dao;

import com.example.zgq.model.test.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 描述：用户DAO
 * @author zgq
 * @date   2017/11/20.
 */
@Mapper
public interface UserDao {

    /**
     *  描述：通过用户名和密码查询用户
     * @param name
     * @param password
     */
    User findByNameAndPassword(@Param("name") String name, @Param("password") String password);

    /**
     *  描述：通过用户名查询用户
     * @param name
     */
    User findByUserName(@Param("name") String name);

}
