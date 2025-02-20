package com.bflsz.springbootgit.mapper;

import com.bflsz.springbootgit.pojo.Comment;
import org.apache.ibatis.annotations.*;

@Mapper
public interface CommentMapper {

    @Select("SELECT COUNT(1) FROM comment WHERE comment_id = #{commentId}")
    boolean existsById(Integer commentId);

    @Insert("INSERT INTO comment(post_id,user_id,parent_comment_id,content,like_count)" +
            "VALUES (#{postId},#{userId},#{parentCommentId},#{content},#{likeCount})")
    @Options(useGeneratedKeys = true, keyProperty = "commentId")
    int insert(Comment comment);

    @Update("UPDATE comment set like_count=like_count+1 where comment_id=#{commentId}")
    int update(Integer commentId);
}
