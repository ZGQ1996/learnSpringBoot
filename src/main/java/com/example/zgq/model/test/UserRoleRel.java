package com.example.zgq.model.test;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 描述：用户角色关联
 * @author   zgq
 * @date     2017/12/10.
 */
@Entity
@Table(name = "user_role_rel")
public class UserRoleRel {
    @Id
    private String userId;
    private String roleId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
