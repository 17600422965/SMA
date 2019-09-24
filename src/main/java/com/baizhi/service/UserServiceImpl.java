package com.baizhi.service;

import com.baizhi.dao.UserDAO;
import com.baizhi.entity.User;
import com.baizhi.util.MybatisUtil;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public User checkusername(String username) {
        UserDAO userDAO = MybatisUtil.getSqlSession().getMapper(UserDAO.class);
        //通过用户名查询
        User user = userDAO.selectByUserName(username);
        MybatisUtil.close();
        return user;
    }

    @Override
    public List<User> showAll() {
        UserDAO userDAO = MybatisUtil.getSqlSession().getMapper(UserDAO.class);
        List<User> users = userDAO.selectAll();
        MybatisUtil.close();
        return users;
    }
}
