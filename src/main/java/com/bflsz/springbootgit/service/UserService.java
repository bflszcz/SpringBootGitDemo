package com.bflsz.springbootgit.service;

import com.bflsz.springbootgit.pojo.User;

import java.util.List;

public interface UserService {
    User getUserById(Integer id);
    void addUser(User user);
    User login(String username,String password);
    void modifyPassword(Integer id,String oldPassword,String newPassword);
    void deleteUser(Integer id);
}
