package com.bflsz.springbootgit.controller;

import cn.hutool.cron.task.Task;
import com.bflsz.springbootgit.pojo.ProjectTask;
import com.bflsz.springbootgit.pojo.Result;
import com.bflsz.springbootgit.pojo.TaskOutput;
import com.bflsz.springbootgit.service.ProjectTaskService;
import com.bflsz.springbootgit.utils.R;
import jakarta.persistence.PreUpdate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/tasks")
public class ProjectTaskController {

    @Autowired
    private ProjectTaskService projectTaskService;

    //创建任务
    @PostMapping
    public Result addTask(@RequestBody ProjectTask projectTask){
        try {
            projectTaskService.addTask(projectTask);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
        log.info("创建任务成功");
        return Result.success();
    }

    //根据ID查询任务
    @GetMapping
    public ProjectTask getTaskById(Integer id){
        return projectTaskService.getTaskById(id);
    }

    //任务进度更新
    @PutMapping("/progress")
    public Result updateTask(@RequestParam Integer id,@RequestParam Integer progress,String status){
        projectTaskService.updateTask(id,progress,status);
        log.info("任务进度更新成功");
        return Result.success();
    }

    //成果上传
    @PostMapping("/output")
    public Result addTaskOutput(@RequestBody TaskOutput taskOutput){
        try {
            projectTaskService.addTaskOutput(taskOutput);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
        log.info("成果上传成功");
        return Result.success();
    }
}
