package com.bflsz.springbootgit.service.impl;

import com.bflsz.springbootgit.mapper.ProjectMapper;
import com.bflsz.springbootgit.pojo.Project;
import com.bflsz.springbootgit.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    ProjectMapper projectMapper;

    @Override
    public void addProject(Project project) {
         projectMapper.release(project);
    }

    @Override
    public List<Project> showProject() {
        return projectMapper.showAllProject();
    }

    @Override
    public void deleteProjectById(Integer id) {
        projectMapper.deleteProjectById(id);

    }
}
