package com.jiayeli.blog.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiayeli.blog.dao.ArticleMapper;
import com.jiayeli.blog.dao.RecommendInfoMapper;
import com.jiayeli.blog.dao.RecommendListMapper;
import com.jiayeli.blog.dto.ArticleDto;
import com.jiayeli.blog.dto.RecommendArticleDto;
import com.jiayeli.blog.dto.TitleComponentsModel;
import com.jiayeli.blog.model.ArticleModel;
import com.jiayeli.blog.model.recommend.RecommendInfoModel;
import com.jiayeli.blog.model.recommend.RecommendListModel;
import com.jiayeli.blog.service.RecommendInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author kuro@jiayeli.cn
 * @since 2024-10-04 22:49:36
 */
@Service
public class RecommendInfoServiceImpl extends ServiceImpl<RecommendInfoMapper, RecommendInfoModel> implements RecommendInfoService {

    @Autowired
    private RecommendInfoMapper recommendInfoMapper;

    @Autowired
    private RecommendListMapper recommendListMapper;

    @Autowired
    private ArticleMapper articleMapper;
    @Override
    public List<RecommendArticleDto> getRecommendList() {
        List<RecommendInfoModel> allRecommendInfoModels = recommendInfoMapper.selectList(new LambdaQueryWrapper<RecommendInfoModel>().eq(RecommendInfoModel::getDelete, 0));
        List<String> recommendInfoIdList = allRecommendInfoModels.stream().map(RecommendInfoModel::getId).collect(Collectors.toList());
        System.out.println(recommendInfoIdList.get(0));
        List<RecommendListModel> allRecommendListModels = recommendListMapper.selectList(new LambdaQueryWrapper<RecommendListModel>().in(RecommendListModel::getArticleId, recommendInfoIdList));
        List<ArticleModel> allArticleModelList = articleMapper.selectBatchIds(allRecommendListModels.stream().map(RecommendListModel::getArticleId).collect(Collectors.toList()));
        Map<String, List<RecommendListModel>> recommendListInfo = allRecommendListModels.stream().collect(Collectors.groupingBy(RecommendListModel::getRecommendId));
        Map<String, RecommendInfoModel> recommendInfoModelMap = allRecommendInfoModels.stream().collect(Collectors.toMap(RecommendInfoModel::getId, recommendInfoModel -> recommendInfoModel));
        Map<String, ArticleModel> recommendArticleModelMap = allArticleModelList.stream().collect(Collectors.toMap(ArticleModel::getId, articleModel -> articleModel));

        ArrayList<RecommendArticleDto> recommendArticleDtoList = new ArrayList<>();
        for (Map.Entry<String, List<RecommendListModel>> recommendList : recommendListInfo.entrySet()) {
            String recommendInfoId = recommendList.getKey();
            RecommendInfoModel recommendInfoModel = recommendInfoModelMap.get(recommendInfoId);
            List<ArticleDto> articleDtoList = new ArrayList<>();
            for (String recommendArticleId : recommendList.getValue().stream().map(RecommendListModel::getArticleId).toList()) {
                ArticleModel articleModel = recommendArticleModelMap.get(recommendArticleId);
                ArticleDto articleDto = new ArticleDto();
                convert2ArticleDto(articleModel, articleDto);
                articleDtoList.add(articleDto);
            }
            RecommendArticleDto recommendArticleDto = add2RecommendDtoList(recommendInfoModel, articleDtoList);
            recommendArticleDtoList.add(recommendArticleDto);
        }
        return recommendArticleDtoList;
    }

    private void convert2ArticleDto(ArticleModel articleModel, ArticleDto articleDto) {
        BeanUtils.copyProperties(articleModel, articleDto);
    }

    private RecommendArticleDto add2RecommendDtoList(RecommendInfoModel recommendInfoModel, List<ArticleDto> articleList) {
        return RecommendArticleDto.builder()
                .id(recommendInfoModel.getId())
                .order(recommendInfoModel.getOrder())
                .titleComponentsModel(TitleComponentsModel.builder()
                        .recommendTopic(recommendInfoModel.getRecommendTopic())
                        .describe(recommendInfoModel.getDescribe())
                        .coverImage(recommendInfoModel.getCoverImage())
                        .build())
                .articleList(articleList)
                .build();
    }
}
