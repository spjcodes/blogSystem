package com.jiayeli.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiayeli.blog.dao.ArticleCategoryInfoMapper;
import com.jiayeli.blog.dao.ArticleCategoryMapper;
import com.jiayeli.blog.dto.ArticleCategoryDto;
import com.jiayeli.blog.model.article.ArticleCategoryInfoModel;
import com.jiayeli.blog.model.article.ArticleCategoryModel;
import com.jiayeli.blog.service.ArticleCategoryService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ArticleCategorySerImpl  extends ServiceImpl<ArticleCategoryMapper, ArticleCategoryModel> implements ArticleCategoryService {
    @Autowired
    private ArticleCategoryMapper articleCategoryMapper;

    @Autowired
    private ArticleCategoryInfoMapper articleCategoryInfoMapper;

    @Override
    public List<ArticleCategoryDto> getArticleCategoryListByAuthorId(String authorId) {
        List<ArticleCategoryModel> articleCategoryModels = articleCategoryMapper.selectList(new LambdaQueryWrapper<ArticleCategoryModel>()
                .eq(ArticleCategoryModel::getAuthorId, authorId)
        );
        if(ObjectUtils.isEmpty(articleCategoryModels))
            return null;

        List<String> categoryIdList = articleCategoryModels.stream().map(ArticleCategoryModel::getId).collect(Collectors.toList());
        List<ArticleCategoryInfoModel> articleCategoryInfoList = articleCategoryInfoMapper.selectList(
                new LambdaQueryWrapper<ArticleCategoryInfoModel>()
                        .in(ArticleCategoryInfoModel::getCategoryId, categoryIdList)
        );
        Map<String, List<ArticleCategoryInfoModel>> articleCategoryInfoMap = articleCategoryInfoList.stream().collect(Collectors.groupingBy(ArticleCategoryInfoModel::getCategoryId));
        return articleCategoryModels.stream()
                .map(c -> {
                    List<ArticleCategoryInfoModel> articleCategoryInfoModels = articleCategoryInfoMap.get(c.getId());
                    return ObjectUtils.isEmpty(articleCategoryInfoModels) ? null : convert2ArticleCategoryDto(c, articleCategoryInfoModels);
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private ArticleCategoryDto convert2ArticleCategoryDto(ArticleCategoryModel articleCategoryModel, List<ArticleCategoryInfoModel> articleCategoryInfoModels) {
        ArticleCategoryDto articleCategoryDto = new ArticleCategoryDto();
        BeanUtils.copyProperties(articleCategoryModel, articleCategoryDto);
        List<String> articleIdList = articleCategoryInfoModels.stream().map(ArticleCategoryInfoModel::getArticleId).toList();
        articleCategoryDto.setArticleIdList(articleIdList);
        return articleCategoryDto;
    }
}
