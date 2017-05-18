package com.dayton.rest.mq.domain;
/**
 * Created by daimian on 17-5-17.
 */

import java.io.Serializable;

/**
 * 新闻类
 *
 * @author Damian
 * @create 2017-05-17 下午5:57
 **/
public class News extends BaseEntity implements Serializable{

    private Long id;

    private String title;

    private String author;

    private String content;

    private String url;

    public News() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "News[" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", content='" + content + '\'' +
                ", url='" + url + '\'' +
                ']';
    }

}
