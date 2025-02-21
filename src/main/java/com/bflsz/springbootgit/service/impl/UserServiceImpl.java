package com.bflsz.springbootgit.service.impl;

import ch.qos.logback.core.util.StringUtil;
import cn.hutool.crypto.digest.BCrypt;
import cn.hutool.json.JSONObject;
import com.bflsz.springbootgit.mapper.UserMapper;
import com.bflsz.springbootgit.pojo.User;
import com.bflsz.springbootgit.service.UserService;
import com.bflsz.springbootgit.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(Integer id) {
        return userMapper.selectById(id);
    }

    @Override
    public void addUser(User user) {
        // 基础校验（用户名/密码非空）
        validateUserInput(user);

        // 检查用户名是否已存在
        if (userMapper.selectByUsername(user.getUsername()) != null) {
            throw new IllegalArgumentException("用户名已存在");
        }

        // 密码复杂度校验
        if (!isPasswordValid(user.getPassword())) {
            throw new IllegalArgumentException("密码需包含至少8位，且含字母和数字");
        }

        // 密码加密存储
        user.setPassword(encodePassword(user.getPassword()));

        user.setCreateTime(LocalDateTime.now());
        userMapper.insert(user);
    }

    @Override
    public User login(String username, String password) {
        //1.查询用户是否存在
        User user = userMapper.selectByUsername(username);
        System.out.println(user);
        if (user == null) {
            throw new IllegalArgumentException("用户名或密码错误");
        }
        //2.验证密码是否匹配
        if (!BCrypt.checkpw(password, user.getPassword())) {
            throw new IllegalArgumentException("用户名或密码错误");
        }
        //3.生成Token
        JSONObject tokenPayLoad = new JSONObject().set("userId", user.getId());
        String token = TokenUtil.createToken(tokenPayLoad);
        user.setToken(token);
        return user;
    }

    @Override
    public void modifyPassword(Integer id, String oldPassword, String newPassword) {
        User user = userMapper.selectById(id);
        if (!BCrypt.checkpw(oldPassword, user.getPassword())) {
            throw new IllegalArgumentException("密码错误");
        }
        //密码复杂度校验
        if (!isPasswordValid(newPassword)) {
            throw new IllegalArgumentException("密码需包含至少8位，且含字母和数字");
        }
        userMapper.update(id, encodePassword(newPassword));

    }

    @Override
    public void deleteUser(Integer id) {
        userMapper.deleteById(id);
    }

    // 基础字段非空校验
    private void validateUserInput(User user) {
        if (user.getUsername() == null || user.getUsername().trim().isEmpty()) {
            throw new IllegalArgumentException("用户名不能为空");
        }
        if (user.getPassword() == null || user.getPassword().trim().isEmpty()) {
            throw new IllegalArgumentException("密码不能为空");
        }
    }

    // 密码复杂度校验（至少8位，包含字母和数字）
    private boolean isPasswordValid(String password) {
        String pattern = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";
        return password.matches(pattern);
    }

    // 密码加密（使用 BCrypt）
    private String encodePassword(String rawPassword) {
        return BCrypt.hashpw(rawPassword, BCrypt.gensalt());
    }
}
