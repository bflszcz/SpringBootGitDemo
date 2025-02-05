package com.bflsz.springbootgit.service;

import com.bflsz.springbootgit.pojo.User;

import java.util.List;

public interface UserService {
    User getUserById(Integer id);
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(Integer id);
}
