package com.bflsz.springbootgit.service;

import com.bflsz.springbootgit.pojo.Post;

public interface PostService {
    void post(Post post);

    void likePost(Integer postId);
}
