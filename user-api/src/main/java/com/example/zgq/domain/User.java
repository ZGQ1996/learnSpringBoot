package com.example.zgq.domain;


/**
 * @ Author     ：Zgq
 * @ Date       ：Created in 12:23 2019/3/10
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public class User {

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
