package com.jiayeli.blog.control;

import com.jiayeli.blog.model.BlogArticle;
import com.jiayeli.blog.service.BlogArticleSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin
public class BlogArticleCon {

    @Autowired
    private BlogArticleSer blogArticleSer;

    @PostMapping("addBlogArtcle")
    @ResponseBody
    public boolean addBlogArtcle(@RequestBody BlogArticle blogArticle) {
        return blogArticleSer.addBlogArticle(blogArticle);
    }

    @PostMapping("updateBlogArtcle")
    @ResponseBody
    public boolean updateBlogArtcle(@RequestBody BlogArticle blogArticle) {
        return blogArticleSer.updateBlogArticle(blogArticle);
    }

    @PostMapping("deleteBlogArtcle")
    @ResponseBody
    public boolean deleteBlogArtcle(@RequestBody String id) {
        return blogArticleSer.deleteBlogArticle(id);
    }


}
