package com.bflsz.springbootgit.service;

import com.bflsz.springbootgit.pojo.Project;

import java.util.List;

public interface ProjectService {
    void addProject(Project project);
    List<Project> showProject();
    void deleteProjectById(Integer id);
}
