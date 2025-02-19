package com.bflsz.springbootgit.service.impl;

import com.bflsz.springbootgit.mapper.DonateMapper;
import com.bflsz.springbootgit.pojo.Donate;
import com.bflsz.springbootgit.service.DonateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class DonateServiceImpl implements DonateService {
    @Autowired
    private DonateMapper donateMapper;

    @Override
    public void donate(Donate donate) {
        donate.setDonateTime(LocalDateTime.now());
        donateMapper.insert(donate);
    }
}
