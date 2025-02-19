package com.bflsz.springbootgit.service.impl;

import com.bflsz.springbootgit.mapper.ProjectMapper;
import com.bflsz.springbootgit.mapper.UserMapper;
import com.bflsz.springbootgit.mapper.VolunteerMapper;
import com.bflsz.springbootgit.pojo.VolunteerApply;
import com.bflsz.springbootgit.service.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class VolunteerServiceImpl implements VolunteerService {
    @Autowired
    VolunteerMapper volunteerMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public void applyVol(VolunteerApply volunteerApply) {
        volunteerApply.setApplyTime(LocalDateTime.now());
        volunteerMapper.insert(volunteerApply);
    }


}
