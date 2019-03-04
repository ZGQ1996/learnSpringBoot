package com.example.zgq.model.test;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @ Author     ：Zgq
 * @ Date       ：Created in 11:49 2019/3/1
 * @ Description：对应数据库表的user
 * @ Modified By：
 * @Version: $
 */

@Entity
@Table(name = "user")
public class User implements Serializable{

    @Id
    private String id;

    private String name;

    private String password;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
