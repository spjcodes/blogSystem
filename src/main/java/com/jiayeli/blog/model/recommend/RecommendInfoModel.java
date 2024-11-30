package com.jiayeli.blog.model.recommend;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author kuro@jiayeli.cn
 * @since 2024-10-04 22:49:36
 */
@Data
@TableName("recommendInfo")
@Schema(name = "RecommendInfoModel", description = "")
public class RecommendInfoModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableField("`id`")
    private String id;

    @TableField("`order`")
    private Integer order;

    @TableField("`recommendTopic`")
    private String recommendTopic;

    @TableField("`describe`")
    private String describe;

    @TableField("`coverImage`")
    private String coverImage;

    @TableField("`delete`")
    private boolean delete;

    public boolean getDelete() {
        return this.delete;
    }
}
