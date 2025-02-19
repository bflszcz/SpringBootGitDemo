package com.bflsz.springbootgit.controller;

import com.bflsz.springbootgit.pojo.Result;
import com.bflsz.springbootgit.pojo.VolunteerApply;
import com.bflsz.springbootgit.service.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vols")
public class VolunteerController {
    @Autowired
    private VolunteerService volunteerService;

    //申请成为志愿者
    @PostMapping("/apply")
    public Result apply(@RequestBody VolunteerApply volunteerApply){
        volunteerService.applyVol(volunteerApply);
        return Result.success();
    }
}
