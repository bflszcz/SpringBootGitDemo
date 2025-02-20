package com.bflsz.springbootgit.pojo;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    private Integer postId;
    private Integer userId;
    private Integer projectId;
    private String title;
    private String content;
    private LocalDateTime postTime;
    private int viewCount;
    private int likeCount;
    private int commentCount;
}
