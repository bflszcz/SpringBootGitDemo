package com.bflsz.springbootgit.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {
    private int id;
    private String title;
    private String description;
    private String target;
    private String location;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String status;


    @Column(updatable = false)
    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    @PrePersist
    protected void onCreate(){
        createTime=LocalDateTime.now();
        updateTime=LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate(){
        updateTime=LocalDateTime.now();
    }
}
