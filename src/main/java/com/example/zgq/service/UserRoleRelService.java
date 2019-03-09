package com.example.zgq.service;

import com.example.zgq.model.test.UserRoleRel;

import java.util.List;

/**
 * 描述：用户角色关联Service
 * @author 周国庆
 * @date   2017/10/14
 */
public interface UserRoleRelService {

    List<UserRoleRel> findByUserId(String userId);
}
