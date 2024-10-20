package com.jiayeli.blog.model.recommend;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("recommendList")
public class RecommendListModel {
    @TableField("recommendId")
    private String recommendId;
    @TableField("articleId")
    private String  articleId;
}
