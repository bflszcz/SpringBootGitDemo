package com.bflsz.springbootgit.mapper;

import com.bflsz.springbootgit.pojo.Donate;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface DonateMapper {

    @Insert("INSERT INTO donate(user_id,project_id,amount,payment_method,donor_name)" +
            "VALUES (#{userId},#{projectId},#{amount},#{paymentMethod},#{donorName})")
    @Options(useGeneratedKeys = true, keyProperty = "donateId")
    int insert(Donate donate);
}
