package com.bflsz.springbootgit.controller;

import ch.qos.logback.core.util.StringUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.bflsz.springbootgit.pojo.Result;
import com.bflsz.springbootgit.pojo.User;
import com.bflsz.springbootgit.service.UserService;
import com.bflsz.springbootgit.utils.R;
import com.bflsz.springbootgit.utils.ResponseEnum;
import com.bflsz.springbootgit.utils.TokenUtil;
import io.micrometer.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    //通过id查询
    @GetMapping("/{id}")
    public Result getUserById(@PathVariable Integer id){
        User userById = userService.getUserById(id);
        return Result.success(userById);
    }

    //用户注册
    @PostMapping("/register")
    public Result register(@RequestBody User user) {
        userService.addUser(user);
        log.info("添加成功");
        return Result.success();
    }

    //用户登录
    @PostMapping("/login")
    public R<User> login(@RequestParam String username,@RequestParam String password){
        User user=userService.login(username,password);
        log.info("登录成功");
        return R.ok(user);
    }

    //更改密码
    @PostMapping("/modifyPassword")
    public Result modifyPassword(@RequestParam Integer id,@RequestParam String oldPassword,@RequestParam String newPassword){
        try {
            userService.modifyPassword(id,oldPassword,newPassword);
        } catch (IllegalArgumentException e) {
            log.error(e.getMessage());
            return Result.error(e.getMessage());
        }
        log.info("密码更改成功");
        return Result.success();
    }
}
