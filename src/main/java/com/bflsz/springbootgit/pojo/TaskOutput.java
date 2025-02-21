package com.bflsz.springbootgit.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskOutput {
    private Integer id;
    private Integer taskId;
    private String resourceType;
    private String resourceUrl;
    private String description;
    private Integer uploadedBy;
    private LocalDateTime createTime;
}
