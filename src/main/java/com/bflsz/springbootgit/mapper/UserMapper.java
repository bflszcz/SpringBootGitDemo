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

    @Update("UPDATE user SET password = #{password} WHERE id= #{id}")
    int update(Integer id,String password);

    @Delete("DELETE FROM user WHERE id = #{id}")
    int deleteById(Integer id);

    @Select("SELECT * FROM user where username=#{username}")
    User selectByUsername(String username);
}
