package com.jiayeli.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleCategoryDto {
    String id;
    private String category;
    private String desc;
    private List<String> articleIdList;
}
