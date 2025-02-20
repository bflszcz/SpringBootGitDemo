package com.bflsz.springbootgit.service.impl;

import com.bflsz.springbootgit.mapper.PostMapper;
import com.bflsz.springbootgit.pojo.Post;
import com.bflsz.springbootgit.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostMapper postMapper;

    @Override
    public void post(Post post) {
        post.setPostTime(LocalDateTime.now());
        postMapper.insert(post);
    }

    @Override
    public void likePost(Integer postId) {
        if(!postMapper.existsById(postId)){
            throw new IllegalArgumentException("postId为"+postId+"的帖子不存在");
        }
        postMapper.update(postId);
    }
}
