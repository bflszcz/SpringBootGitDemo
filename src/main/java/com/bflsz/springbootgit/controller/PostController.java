package com.bflsz.springbootgit.controller;

import com.bflsz.springbootgit.pojo.Post;
import com.bflsz.springbootgit.pojo.Result;
import com.bflsz.springbootgit.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    //发布帖子
    @PostMapping
    public Result post(@RequestBody Post post){
        try{
            postService.post(post);
            log.info("帖子发布成功");
           return Result.success();
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }
}
