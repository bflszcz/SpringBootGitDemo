package com.bflsz.springbootgit.controller;
import com.bflsz.springbootgit.pojo.Comment;
import com.bflsz.springbootgit.pojo.Result;
import com.bflsz.springbootgit.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;

    //发布评论(parentCommentId可关联回复的评论,为null则代表顶级评论)
    @PostMapping
    public Result addComment(@RequestBody Comment comment){
        try{

            commentService.addComment(comment);
            log.info("回复发布成功");
            return Result.success();
        }catch (IllegalArgumentException e){
            log.error(e.getMessage());
            return Result.error(400,e.getMessage());
        }
        catch (Exception e) {
            log.error(e.getMessage());
            return Result.error(500,"系统繁忙,请稍后再试");
        }
    }

    //点赞评论
    @PutMapping("/like")
    public Result likeComment(@RequestParam Integer commentId){
        try {
            commentService.likeComment(commentId);
            log.info("点赞成功");
            return Result.success();
        }catch (IllegalArgumentException e){
            //该评论不存在
            log.error(e.getMessage());
            return Result.error(400,e.getMessage());
        }
        catch (Exception e){
            log.error(e.getMessage());
            return Result.error(500,"系统繁忙,请稍后再试");
        }
    }
}
