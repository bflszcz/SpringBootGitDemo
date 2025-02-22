package com.bflsz.springbootgit.mapper;

import cn.hutool.cron.task.Task;
import com.bflsz.springbootgit.pojo.ProjectTask;
import com.bflsz.springbootgit.pojo.TaskOutput;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ProjectTaskMapper {

    @Insert("INSERT INTO project_task(project_id,task_name,description,status,start_time,end_time,progress)" +
            "VALUES (#{projectId},#{taskName},#{description},#{status},#{startTime},#{endTime},#{progress})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    int insert(ProjectTask projectTask);


    @Update("UPDATE project_task set status=#{status},progress=#{progress} where id=#{id}")
    int update(Integer id, Integer progress,String status);


    @Insert("INSERT INTO task_output(task_id,resource_type,resource_url,description,uploaded_by)" +
            "VALUE (#{taskId},#{resourceType},#{resourceUrl},#{description},#{uploadedBy})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    int insertOutput(TaskOutput taskOutput);


    @Select("SELECT * FROM project_task where id=#{id}")
    ProjectTask select(Integer id);
}
