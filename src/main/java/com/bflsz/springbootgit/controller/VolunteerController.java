package com.bflsz.springbootgit.controller;

import com.bflsz.springbootgit.pojo.Result;
import com.bflsz.springbootgit.pojo.VolunteerApply;
import com.bflsz.springbootgit.service.VolunteerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/vols")
public class VolunteerController {
    @Autowired
    private VolunteerService volunteerService;

    //申请成为志愿者
    @PostMapping("/apply")
    public Result apply(@RequestBody VolunteerApply volunteerApply){
        try{
            volunteerService.applyVol(volunteerApply);
            return Result.success();
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }

    //管理员审核志愿者
    @PutMapping("/verify")
    public Result verify(@RequestParam int id,String status){
        try {
            volunteerService.verify(id,status);
            return Result.success();
        }
        catch (Exception e){
            log.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }

    }
}
