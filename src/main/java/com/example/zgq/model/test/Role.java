package com.example.zgq.model.test;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 描述：用户角色实体
 * @author zgq
 * @date   2017/12/10.
 */
@Entity
@Table(name = "role")
public class Role {

    @Id
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
