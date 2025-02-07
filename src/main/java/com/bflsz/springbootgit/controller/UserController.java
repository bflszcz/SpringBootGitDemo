package com.bflsz.springbootgit.controller;

import com.bflsz.springbootgit.pojo.Result;
import com.bflsz.springbootgit.pojo.User;
import com.bflsz.springbootgit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    //通过id查询
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id){
        return userService.getUserById(id);
    }

    //用户注册
    @PostMapping("/register")
    public Result<String> register(@RequestBody User user) {
        userService.addUser(user);
        System.out.println("添加成功");
        return new Result<>(200, "User registered successfully",null);
    }
}
