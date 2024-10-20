package com.jiayeli.blog.control;

import com.jiayeli.blog.common.CommonResponseType;
import com.jiayeli.blog.common.response.CommonResponse;
import com.jiayeli.blog.dto.RecommendArticleDto;
import com.jiayeli.blog.service.RecommendInfoService;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 *  recommend controller
 * </p>
 *
 * @author kuro@jiayeli.cn
 * @since 2024-10-04
 */
@Controller
@RequestMapping("recommend")
@Schema(name = "RecommendController", description = "RecommendController controller desc")
public class RecommendController {


    @Autowired
    private RecommendInfoService recommendInfoService;

    @GetMapping("getRecommendList")
    @ResponseBody
    public CommonResponse getRecommendList() {
        List<RecommendArticleDto> recommendList = recommendInfoService.getRecommendList();
        return CommonResponseType.ok(recommendList);
    }
}
