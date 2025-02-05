package com.bflsz.springbootgit.mapper;

import com.bflsz.springbootgit.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user WHERE id = #{id}")
    User selectById(Integer id);

    @Insert("INSERT INTO user (username, password, role, email, create_time, update_time) " +
            "VALUES (#{username}, #{password}, #{role}, #{email}, #{createTime}, #{updateTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(User user);

    @Update("UPDATE user SET username = #{username}, password = #{password}, role = #{role}, " +
            "email = #{email}, update_time = #{updateTime} WHERE id = #{id}")
    int update(User user);

    @Delete("DELETE FROM user WHERE id = #{id}")
    int deleteById(Integer id);
}
