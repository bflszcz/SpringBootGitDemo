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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        System.out.println("添加成功");
        return Result.success();
    }

    //用户登录
    @PostMapping("/login")
    public R<User> login(String username,String password){
        if(StringUtils.isNotBlank(username)&&StringUtils.isNotBlank(password)){
            if("bflsz".equals(username)&&"123456".equals(password)){
                User user=new User();
                JSONObject jsonObject= JSONUtil.createObj().put("name","bflsz");
                String token = TokenUtil.createToken(jsonObject);
                user.setToken(token);
                return R.ok(user);
            }
        }
        return R.error(ResponseEnum.USERNAME_PASSWORD_ERROR);
    }
}
