package com.jiayeli.blog.model;

public class Recommend {
    private String id;

    private String articleid;

    private String recomid;

    private String recomid1;

    private String recomid2;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getArticleid() {
        return articleid;
    }

    public void setArticleid(String articleid) {
        this.articleid = articleid == null ? null : articleid.trim();
    }

    public String getRecomid() {
        return recomid;
    }

    public void setRecomid(String recomid) {
        this.recomid = recomid == null ? null : recomid.trim();
    }

    public String getRecomid1() {
        return recomid1;
    }

    public void setRecomid1(String recomid1) {
        this.recomid1 = recomid1 == null ? null : recomid1.trim();
    }

    public String getRecomid2() {
        return recomid2;
    }

    public void setRecomid2(String recomid2) {
        this.recomid2 = recomid2 == null ? null : recomid2.trim();
    }
}