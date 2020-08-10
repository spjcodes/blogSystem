package com.jiayeli.blog.model;

import java.util.Date;

public class BlogArticle {
    private String id;

    private String title;

    private String intro;

    private String bolgcover;

    private String typeid;

    private Integer iscomment;

    private Boolean isoriginal;

    private Date createtime;

    private Integer isuseful;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }

    public String getBolgcover() {
        return bolgcover;
    }

    public void setBolgcover(String bolgcover) {
        this.bolgcover = bolgcover == null ? null : bolgcover.trim();
    }

    public String getTypeid() {
        return typeid;
    }

    public void setTypeid(String typeid) {
        this.typeid = typeid == null ? null : typeid.trim();
    }

    public Integer getIscomment() {
        return iscomment;
    }

    public void setIscomment(Integer iscomment) {
        this.iscomment = iscomment;
    }

    public Boolean getIsoriginal() {
        return isoriginal;
    }

    public void setIsoriginal(Boolean isoriginal) {
        this.isoriginal = isoriginal;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getIsuseful() {
        return isuseful;
    }

    public void setIsuseful(Integer isuseful) {
        this.isuseful = isuseful;
    }
}