package com.jiayeli.blog.model;

import com.jiayeli.blog.enums.ArticleStatusEnum;

import java.util.List;

public class ArticleModel {
    private String id;
    private String title;
    private String author;
    private String category;
    private String description;
    private String image;
    private String publishDate;
    private String content;
    private List<String> tags;
    private List<CommentModel> comments;
    private List<String> likes;
    private List<String> dislikes;
    private Integer shareCount;
    private Integer viewCount;
    private ArticleStatusEnum status;
    private String createdAt;
    private String updatedAt;
    private String deletedAt;
    private Boolean isDraft;
    private Boolean isDeleted;
    private Boolean isPublished;
    private Boolean isArchived;
    private Boolean isPublic;
}
