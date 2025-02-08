package com.bflsz.springbootgit.controller;

import com.bflsz.springbootgit.pojo.Project;
import com.bflsz.springbootgit.pojo.Result;
import com.bflsz.springbootgit.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    ProjectService projectService;

    //发布项目
    @PostMapping("/release")
    public Result<String> release(@RequestBody Project project){
        projectService.addProject(project);
        System.out.println("项目发布成功");
        return new Result<>(200,"Project released successfully",null);
    }

    //展示所有项目
    @GetMapping
    public List<Project> showAllProjects(){
       return projectService.showProject();
    }

    //根据ID删除项目
    @PostMapping("/delete")
    public Result<String> deleteProjectById(@RequestParam Integer id){
        projectService.deleteProjectById(id);
        System.out.println("删除成功");
        return new Result<>(200,"Project where id="+id+" deleted successfully",null);
    }
}
