package com.bflsz.springbootgit.mapper;

import com.bflsz.springbootgit.pojo.Post;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface PostMapper {

    @Insert("INSERT INTO post(user_id,project_id,title,content,view_count,like_count,comment_count)" +
            "VALUES(#{userId},#{projectId},#{title},#{content},#{viewCount},#{likeCount},#{commentCount})")
    @Options(useGeneratedKeys = true, keyProperty = "postId")
      int insert(Post post);
}
