package com.bflsz.springbootgit.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.Insert;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    private Integer commentId;
    private Integer postId;
    private Integer userId;
    private Integer parentCommentId;
    private String content;
    private LocalDateTime commentTime;
    private Integer likeCount;
}
