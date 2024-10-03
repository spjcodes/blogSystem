package com.jiayeli.blog.model;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Tag(name = "Comments对象", description = "Comments对象 describe")
@TableName("comments")
public class CommentsModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String id;

    private String articleId;

    private String userId;

    private String content;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Boolean isDeleted;

    private LocalDateTime deletedAt;

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

