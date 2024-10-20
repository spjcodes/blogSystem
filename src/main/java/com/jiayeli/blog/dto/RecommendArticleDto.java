package com.jiayeli.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RecommendArticleDto {
    private String id;
    private int order;
    // recommend Title  data model
    private TitleComponentsModel titleComponentsModel;
    // article List
    private List<ArticleDto> articleList;
}

