package com.bflsz.springbootgit.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {
    private String title;
    private String description;
    private String target;
    private String location;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String status;
    private LocalDateTime createTime;
    private LocalDateTime UpdateTime;

}
