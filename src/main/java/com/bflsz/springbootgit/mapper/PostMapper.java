package com.bflsz.springbootgit.mapper;

import com.bflsz.springbootgit.pojo.Post;
import org.apache.ibatis.annotations.*;

@Mapper
public interface PostMapper {

    @Insert("INSERT INTO post(user_id,project_id,title,content,view_count,like_count,comment_count)" +
            "VALUES(#{userId},#{projectId},#{title},#{content},#{viewCount},#{likeCount},#{commentCount})")
    @Options(useGeneratedKeys = true, keyProperty = "postId")
      int insert(Post post);

    @Update("UPDATE post set like_count=like_count+1 where post_id=#{postId}")
    int update(Integer postId);

    @Select("SELECT COUNT(*) from post where post_id=#{postId}")
    boolean existsById(Integer postId);
}
