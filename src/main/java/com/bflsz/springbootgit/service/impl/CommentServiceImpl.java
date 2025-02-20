package com.bflsz.springbootgit.service.impl;

import com.bflsz.springbootgit.mapper.CommentMapper;
import com.bflsz.springbootgit.pojo.Comment;
import com.bflsz.springbootgit.pojo.Result;
import com.bflsz.springbootgit.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public void addComment(Comment comment) {
        comment.setLikeCount(0);
        comment.setCommentTime(LocalDateTime.now());
        commentMapper.insert(comment);
    }

    @Override
    public void likeComment(Integer commentId) {
        if(!commentMapper.existsById(commentId)){
            throw new IllegalArgumentException("commentId为"+commentId+"的评论不存在");
        }
        commentMapper.update(commentId);
    }
}
