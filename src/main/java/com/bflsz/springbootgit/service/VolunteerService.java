package com.bflsz.springbootgit.service;

import com.bflsz.springbootgit.pojo.VolunteerApply;

public interface VolunteerService {

    void applyVol(VolunteerApply volunteerApply);

    void verify(int id, String status);
}
