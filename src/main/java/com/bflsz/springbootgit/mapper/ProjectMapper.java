package com.bflsz.springbootgit.mapper;

import com.bflsz.springbootgit.pojo.Project;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProjectMapper {
    //添加项目
    @Insert("INSERT INTO project(title,description,target,location,start_time,end_time,status,create_time,update_time)"+
    "VALUES (#{title},#{description},#{target},#{location},#{startTime},#{endTime},#{status},#{createTime},#{updateTime})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    int release(Project project);

    //展示所有项目
    @Select("SELECT * from project")
    List<Project> showAllProject();

    //根据ID删除项目
    @Delete("DELETE from project where id=#{id}")
    int deleteProjectById(Integer id);


}
