package com.example.zgq.repository.test;

import com.example.zgq.model.test.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 描述：用户角色Repository
 * @author zgq
 * @date   2017/12/10.
 */
public interface RoleRepository extends JpaRepository<Role,String> {

}
