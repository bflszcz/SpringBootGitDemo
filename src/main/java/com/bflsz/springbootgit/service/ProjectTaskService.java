package com.bflsz.springbootgit.service;

import cn.hutool.cron.task.Task;
import com.bflsz.springbootgit.pojo.ProjectTask;
import com.bflsz.springbootgit.pojo.TaskOutput;

public interface ProjectTaskService {
    void addTask(ProjectTask projectTask);

    void addTaskOutput(TaskOutput taskOutput);

    void updateTask(Integer id, Integer progress,String status);

    ProjectTask getTaskById(Integer id);
}
