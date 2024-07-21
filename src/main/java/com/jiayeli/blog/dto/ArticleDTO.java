package com.jiayeli.blog.dto;

import com.jiayeli.blog.model.CommentModel;
import com.jiayeli.blog.enums.ArticleStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDTO {
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
