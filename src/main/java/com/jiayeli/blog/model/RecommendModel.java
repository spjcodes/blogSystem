package com.jiayeli.blog.model;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecommendModel {
    private String id;

    private String articleid;

    private String recomid;

    private String recomid1;

    private String recomid2;

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

}