package com.jiayeli.blog.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.Date;

public class BlogArticle {
    private String id;

    @NotBlank(message = "标题不能为空")
    private String title;

    private String intro;

    private String bolgcover;

    private String typeid;

    private Integer iscomment;

    @Getter
    @Setter
    private Integer editType;

    private Boolean isoriginal;

    private String content;


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    //将请求发来 yyyy-MM-dd HH:mm:ss形式的String类型的数据解析为date
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createtime;

    private Integer isuseful;

    @Getter
    @Setter
    private Integer visits;

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