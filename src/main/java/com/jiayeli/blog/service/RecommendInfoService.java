package com.jiayeli.blog.service;

import com.jiayeli.blog.dto.RecommendArticleDto;
import com.jiayeli.blog.model.recommend.RecommendInfoModel;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author kuro@jiayeli.cn
 * @since 2024-10-04 22:49:36
 */
public interface RecommendInfoService extends IService<RecommendInfoModel> {

    List<RecommendArticleDto> getRecommendList();
}
