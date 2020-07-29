package com.livre.myhome.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
@Table(name = "blog_page")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class BlogPage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull(message = "id 不能为 null")
    private int id;

    /**
     * Article title.
     */
    @NotEmpty(message = "文章标题不能为空")
    private String blogTitle;

    /**
     * Article content after render to html.
     */
    private String blogContentHtml;

    /**
     * Article content in markdown syntax.
     */
    private String blogContentMd;

    /**
     * Article abstract.
     */
    private String blogAbstract;

    /**
     * Article cover's url.
     */
    private String blogCover;

    /**
     * Article release date.
     */
    private Date blogDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getBlogContentHtml() {
        return blogContentHtml;
    }

    public void setBlogContentHtml(String blogContentHtml) {
        this.blogContentHtml = blogContentHtml;
    }

    public String getBlogContentMd() {
        return blogContentMd;
    }

    public void setBlogContentMd(String blogContentMd) {
        this.blogContentMd = blogContentMd;
    }

    public String getBlogAbstract() {
        return blogAbstract;
    }

    public void setBlogAbstract(String blogAbstract) {
        this.blogAbstract = blogAbstract;
    }

    public String getBlogCover() {
        return blogCover;
    }

    public void setBlogCover(String blogCover) {
        this.blogCover = blogCover;
    }

    public Date getBlogDate() {
        return blogDate;
    }

    public void setBlogDate(Date blogDate) {
        this.blogDate = blogDate;
    }
}
