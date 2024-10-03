package com.jiayeli.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiayeli.blog.dao.CommentsMapper;
import com.jiayeli.blog.model.CommentsModel;
import com.jiayeli.blog.service.CommentsSer;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author kuro@jiayeli.cn
 * @since 2024-10-04
 */
@Service
public class CommentsServiceImpl extends ServiceImpl<CommentsMapper, CommentsModel> implements CommentsSer {

}
