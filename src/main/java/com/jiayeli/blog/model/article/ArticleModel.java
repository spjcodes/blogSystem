package com.jiayeli.blog.model.article;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.jiayeli.blog.enums.ArticleStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Timestamp;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("article")
public class ArticleModel  {
    @TableId("id")
    private String id;
    private String title;
    private String author;
    private String categoryId;
    private String description;
    private String coverImage;
    private String tagIds;
    private String content;
    /*    private CommentModel[] comments;*/
    private int likes;
    private int dislikes;
    private int shareCount;
    private int viewCount;
    @Builder.Default
    @TableField("isPublic")
    private boolean isPublic = true;
    private ArticleStatusEnum status;
    private boolean isArchived;
    private boolean isDelete;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Timestamp deletedAt;
    private Timestamp publishDate;
}
