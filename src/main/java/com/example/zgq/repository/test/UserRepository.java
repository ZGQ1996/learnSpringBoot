package com.example.zgq.repository.test;

import com.example.zgq.model.test.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Collection;
import java.util.List;

/**
 * 描述：用户Repository
 * @author zgq
 * @date   2017/10/14.
 */
public interface UserRepository extends JpaRepository<User,String>{

    /**
     * 描述：通过名字相等查询，参数为 name
     * 相当于：select u from user u where u.name = ?1
     */
    List<User> findByName(String name);

    /**
     * 描述：通过名字like查询，参数为 name
     * 相当于：select u from user u where u.name like ?1
     */
    List<User> findByNameLike(String name);

    /**
     * 描述：通过主键id集合查询，参数为 id集合
     * 相当于：select u from user u where id in(?,?,?)
     * @param ids
     */
    List<User> findByIdIn(Collection<String> ids);



}
