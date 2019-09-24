package com.baizhi.dao;

import com.baizhi.entity.User;

import java.util.List;

public interface UserDAO {
    //检测用户名是否唯一
    public User selectByUserName(String username);
    //查询所有
    public List<User> selectAll();
}
