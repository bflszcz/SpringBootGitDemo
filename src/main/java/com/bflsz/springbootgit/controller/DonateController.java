package com.bflsz.springbootgit.controller;

import com.bflsz.springbootgit.pojo.Donate;
import com.bflsz.springbootgit.pojo.Result;
import com.bflsz.springbootgit.service.DonateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@Slf4j
@RestController
@RequestMapping("/donations")
public class DonateController {
    @Autowired
    private DonateService donateService;

    //创建捐赠
    @PostMapping
    public Result donate(@RequestBody Donate donate){
        donateService.donate(donate);
        return Result.success();
    }

    //生成捐赠报表
    @GetMapping
    public Result report(){
        log.info("捐赠报表展示");
        return Result.success(donateService.report());
    }
}
