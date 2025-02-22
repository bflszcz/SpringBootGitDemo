package com.bflsz.springbootgit.service.impl;

import com.bflsz.springbootgit.mapper.ProjectTaskMapper;
import com.bflsz.springbootgit.pojo.ProjectTask;
import com.bflsz.springbootgit.pojo.TaskOutput;
import com.bflsz.springbootgit.service.ProjectTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectTaskServiceImpl implements ProjectTaskService {
    @Autowired
    private ProjectTaskMapper projectTaskMapper;

    @Override
    public void addTask(ProjectTask projectTask) {
        projectTask.setStatus("not_started");
        projectTaskMapper.insert(projectTask);
    }

    @Override
    public void updateTask(Integer id, Integer progress, String status) {
        ProjectTask task = projectTaskMapper.select(id);
        if (task == null) {
            throw new IllegalArgumentException("当前ID为" + id + "的任务不存在");
        }
        // 进度值校验
        if (progress < 0 || progress > 100) {
            throw new IllegalArgumentException("进度值无效");
        }
        projectTaskMapper.update(id, progress, status);
    }


    @Override
    public ProjectTask getTaskById(Integer id) {
        ProjectTask task = projectTaskMapper.select(id);
        if (task == null) {
            throw new IllegalArgumentException("当前ID为" + id + "的任务不存在");
        }
        return task;
    }

    @Override
    public void addTaskOutput(TaskOutput taskOutput) {
        projectTaskMapper.insertOutput(taskOutput);
    }
}


