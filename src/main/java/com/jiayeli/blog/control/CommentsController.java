package com.jiayeli.blog.control;

import com.jiayeli.blog.common.CommonResponseType;
import com.jiayeli.blog.common.response.CommonResponse;
import com.jiayeli.blog.dao.CommentsMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author kuro@jiayeli.cn
 * @since 2024-10-04
 */
@Controller
@RequestMapping("comments")
@Schema(name = "commentsController", description = "comments controller desc")
public class CommentsController {

    @Autowired
    private CommentsMapper commentsMapper;

    @Operation(summary = "getCommentsList", description = "get all comments list")
    @GetMapping("getCommentsList")
    @ResponseBody
    public CommonResponseType getCommentsList() {
        return CommonResponseType.ok(commentsMapper.selectList(null));
    }
}
