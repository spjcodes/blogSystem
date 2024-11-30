package com.jiayeli.blog.model.article;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author kuro@jiayeli.cn
 * @since 2024-11-23 21:19:48
 */
@Getter
@Setter
@TableName("articleCategoryInfo")
@Schema(name = "ArticleCategoryInfo对象", description = "")
public class ArticleCategoryInfoModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("id")
    private String id;

    @TableField("articleId")
    private String articleId;

    @TableField("categoryId")
    private String categoryId;
}
