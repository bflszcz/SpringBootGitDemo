package com.bflsz.springbootgit.controller;

import com.bflsz.springbootgit.pojo.Project;
import com.bflsz.springbootgit.pojo.Result;
import com.bflsz.springbootgit.service.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    //发布项目
    @PostMapping("/release")
    public Result release(@RequestBody Project project){
        projectService.addProject(project);
       log.info("项目发布成功");
        return Result.success();
    }

    //展示所有项目
    @GetMapping
    public Result showAllProjects(){
        log.info("展示全部项目");

        //调用service查询数据
        List<Project> list=projectService.showProject();
       return Result.success(list);
    }

    //根据ID删除项目
    @PostMapping("/delete")
    public Result deleteProjectById(@RequestParam Integer id){
        projectService.deleteProjectById(id);
        log.info("删除成功");
        return Result.success();
    }
}
