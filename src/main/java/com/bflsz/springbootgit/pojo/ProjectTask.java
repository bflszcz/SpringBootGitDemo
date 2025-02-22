package com.bflsz.springbootgit.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectTask {
    private Integer id;
    private Integer projectId;
    private String taskName;
    private String description;
    private String status;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Integer progress;
    private LocalDateTime createTime;

}
