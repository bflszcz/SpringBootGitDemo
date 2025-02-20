package com.bflsz.springbootgit.controller;

import com.bflsz.springbootgit.pojo.Post;
import com.bflsz.springbootgit.pojo.Result;
import com.bflsz.springbootgit.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    //发布帖子
    @PostMapping
    public Result post(@RequestBody Post post) {
        try {
            postService.post(post);
            log.info("帖子发布成功");
            return Result.success();
        } catch (Exception e) {
            log.error(e.getMessage());
            return Result.error(e.getMessage());
        }
    }

    //点赞帖子
    @PutMapping("/like")
    public Result likePost(@RequestParam Integer postId) {
        try {
            postService.likePost(postId);
            log.info("点赞成功");
            return Result.success();
        } catch (IllegalArgumentException e) {
            log.error(e.getMessage());
            return Result.error(400,e.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage());
            return Result.error(500,"系统繁忙,请稍后再试");
        }
    }
}
