package com.bflsz.springbootgit.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VolunteerApply {
    private int id;
    private Integer userId;
    private Integer projectId;
    private String status;
    private LocalDateTime applyTime;
}
