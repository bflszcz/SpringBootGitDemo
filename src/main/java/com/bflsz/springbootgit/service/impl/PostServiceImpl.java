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
}
