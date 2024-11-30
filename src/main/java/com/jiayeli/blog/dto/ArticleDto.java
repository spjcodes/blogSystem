package com.jiayeli.blog.dto;

import com.jiayeli.blog.model.CommentsModel;
import com.jiayeli.blog.enums.ArticleStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDto {
    private String id;
    private String title;
    private String author;
    private String category;
    private String description;
    private String coverImage;
    private String content;
    private String[] tags;
    private int likes;
    private int dislikes;
    private int shareCount;
    private int viewCount;
    private ArticleStatusEnum status;
    private String isArchived;
    private String createdAt;
    private String updatedAt;
    private boolean deletedAt;
    private String publishDate;
}
