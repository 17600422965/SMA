package com.baizhi.action;

import com.alibaba.fastjson.JSON;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.baizhi.service.UserServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class UserAction extends ActionSupport {
    //接收用户名
    private  String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String checkusername(){
        //调用service方法
        UserService userService = new UserServiceImpl();
        User user = userService.checkusername(username);
        //struts2获取response方式
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("UTF-8");
        try {
            PrintWriter out = response.getWriter();
            //判断用户名是否为null
            if(user!=null){
                out.print("您的用户名已被注册  不可用");
            }else{
                out.print("您的用户名合法可用");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String showAll(){
        //调用service
        UserService userService = new UserServiceImpl();
        List<User> users = userService.showAll();
        //把集合转换成json串
        String jsonString = JSON.toJSONString(users);
        //获取流把json串响应给前台
        HttpServletResponse response = ServletActionContext.getResponse();
        //设置响应编码格式
        response.setCharacterEncoding("UTF-8");
        try {
            PrintWriter out = response.getWriter();
            out.print(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
