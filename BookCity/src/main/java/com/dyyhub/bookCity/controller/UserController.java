package com.dyyhub.bookCity.controller;

import com.dyyhub.bookCity.pojo.User;
import com.dyyhub.bookCity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("")
public class UserController {


    @Autowired
    @Qualifier("UserService")
    UserService userService;

    //查询所有user
    @RequestMapping("/findAll")
    public ModelAndView findAll(ModelAndView modelAndView){
        List<User> userList = userService.findAll();
        modelAndView.addObject("user",userList);
        modelAndView.setViewName("test");
        return modelAndView;
    }
}
