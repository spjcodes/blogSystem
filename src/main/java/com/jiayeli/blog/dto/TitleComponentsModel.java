package com.jiayeli.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TitleComponentsModel {
    private String recommendTopic;
    private String describe;
    private String coverImage;
}