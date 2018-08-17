package com.hand.controller;

import com.hand.entity.User;
import com.hand.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName ssmDemo
 * @ClassName UserController
 * @Description TODO
 * @Author 赵晓宇
 * @Date 2018/8/12 13:46
 * @Version 1.0
 **/
@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value="checkLogin",method = RequestMethod.POST)
    public String selectUserById (@RequestParam("id") int id, @RequestParam("username") String username,
                                  @RequestParam("password") String password) {
        User user = userService.selectUserById(id);
        String uname = user.getUsername();
        String pwd = user.getPassword();
        int flag = user.getFlag();
        //判断是否符合登录条件
        boolean f = uname.equals(username)&&pwd.equals(password)&&flag == 1;
        if (f) {
            //return "redirect:main.jsp";
            return "main";
        } else {
            //return "redirect:error.jsp";
            return "error";
        }


    }

}
