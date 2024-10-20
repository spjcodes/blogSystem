package com.jiayeli.blog.model.recommend;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecommendModel {
    private String id;
    private int order;
    private String recommendTopic;
    private String describe;
    private String coverImage;

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

}