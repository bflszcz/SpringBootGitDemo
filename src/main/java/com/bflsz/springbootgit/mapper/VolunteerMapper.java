package com.bflsz.springbootgit.mapper;

import com.bflsz.springbootgit.pojo.VolunteerApply;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface VolunteerMapper {

    @Insert("INSERT INTO volunteer_apply (user_id,project_id,status)" +
            "VALUES (#{userId},#{projectId},#{status})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    int insert(VolunteerApply volunteerApply);
}
