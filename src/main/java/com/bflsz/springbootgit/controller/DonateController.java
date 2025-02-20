package com.bflsz.springbootgit.controller;

import com.bflsz.springbootgit.pojo.Donate;
import com.bflsz.springbootgit.pojo.Result;
import com.bflsz.springbootgit.service.DonateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/donate")
public class DonateController {
    @Autowired
    private DonateService donateService;

    //创建捐赠
    @PostMapping
    public Result donate(@RequestBody Donate donate){
        donateService.donate(donate);
        return Result.success();
    }
}
