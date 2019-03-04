package com.example.zgq.model.test;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @ Author     ：Zgq
 * @ Date       ：Created in 15:34 2019/3/4
 * @ Description：微信说说实体
 * @ Modified By：
 * @Version: $
 */

@Entity
@Table(name = "mood")
public class Mood implements Serializable{


    @Id
    private String id;

    private String content;

    private String userId;

    private Integer praiseNum;

    private Date publishTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getPraiseNum() {
        return praiseNum;
    }

    public void setPraiseNum(Integer praiseNum) {
        this.praiseNum = praiseNum;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }
}
