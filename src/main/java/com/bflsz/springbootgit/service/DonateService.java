package com.bflsz.springbootgit.service;

import com.bflsz.springbootgit.pojo.Donate;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DonateService {
    void donate(Donate donate);

    List<Donate> report();
}
