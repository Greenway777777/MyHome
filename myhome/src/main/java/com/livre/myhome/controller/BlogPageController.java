package com.livre.myhome.controller;

import com.livre.myhome.pojo.BlogPage;
import com.livre.myhome.result.Result;
import com.livre.myhome.result.ResultFactory;
import com.livre.myhome.service.BlogPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class BlogPageController {
    @Autowired
    BlogPageService blogPageService;

    @PostMapping("api/admin/content/blog")
    public Result saveBlog(@RequestBody @Valid BlogPage blogPage) {
        blogPageService.addOrUpdate(blogPage);
        return ResultFactory.buildSuccessResult("保存成功");
    }

    @GetMapping("/api/blog/{size}/{page}")
    public Result listBlogs(@PathVariable("size") int size, @PathVariable("page") int page) {
        return ResultFactory.buildSuccessResult(blogPageService.list(page - 1, size));
    }

    @GetMapping("/api/blog/{id}")
    public Result getOneBlog(@PathVariable("id") int id) {
        return ResultFactory.buildSuccessResult(blogPageService.findById(id));
    }

    @DeleteMapping("/api/admin/content/blog/{id}")
    public Result deleteBlog(@PathVariable("id") int id) {
        blogPageService.delete(id);
        return ResultFactory.buildSuccessResult("删除成功");
    }
}
