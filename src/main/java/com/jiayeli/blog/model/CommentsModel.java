package com.jiayeli.blog.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Tag(name = "Comments对象", description = "Comments对象 describe")
@TableName("comments")
public class CommentsModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableField("id")
    private String id;

    @TableField("articleId")
    private String articleId;

    @TableField("userId")
    private String userId;

    @TableField("content")
    private String content;

    @TableField("createdAt")
    private Date createdAt;

    @TableField("updatedAt")
    private Date updatedAt;

    @TableField("isDeleted")
    private Boolean isDeleted;

    @TableField("deletedAt")
    private Date deletedAt;

    @Override
    public String toString() {
        return "Comments{" +
                "id = " + id +
                ", articleId = " + articleId +
                ", userId = " + userId +
                ", content = " + content +
                ", createdAt = " + createdAt +
                ", updatedAt = " + updatedAt +
                ", isDeleted = " + isDeleted +
                ", deletedAt = " + deletedAt +
                "}";
    }

}

