package com.example.zgq.model;

/**
 * @ Author     ：Zgq
 * @ Date       ：Created in 11:49 2019/3/1
 * @ Description：对应数据库表的user
 * @ Modified By：
 * @Version: $
 */
public class User {

    private Integer id;

    private String name;

    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
