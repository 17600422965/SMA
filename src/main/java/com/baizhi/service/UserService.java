package com.baizhi.service;

import com.baizhi.entity.User;

import java.util.List;

public interface UserService {
    public User checkusername(String username);

    public List<User> showAll();
}
