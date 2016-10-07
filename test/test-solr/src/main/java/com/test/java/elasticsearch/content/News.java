package com.test.java.elasticsearch.content;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * Created by Micheal on 2016/9/16.
 */
public class News {

    private String title;

    @JSONField(name="create_time")
    private Long createTime;
    private String creator;
    private String content;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public boolean checkNews(News news){
        if(news.getContent()==null||news.getCreateTime()==null||news.getCreator()==null||news.getTitle()==null){
            return false;
        }
        return true;
    }
}
