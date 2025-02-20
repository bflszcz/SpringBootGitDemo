package com.bflsz.springbootgit.service;

import com.bflsz.springbootgit.pojo.Comment;

public interface CommentService {
    void addComment(Comment comment);

    void likeComment(Integer commentId);
}
