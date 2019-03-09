package com.example.zgq.repository.test;

import com.example.zgq.model.test.UserRoleRel;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 描述：用户角色关联Repository
 * @author zgq
 * @date   2017/10/14.
 */
public interface UserRoleRelRepository extends JpaRepository<UserRoleRel,String> {

    List<UserRoleRel> findByUserId(@Param("userId") String userID);
}
