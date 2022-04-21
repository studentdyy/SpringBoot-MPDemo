package com.dyyhub.bookCity.controller;

import com.dyyhub.bookCity.pojo.Cart;
import com.dyyhub.bookCity.pojo.CartItem;
import com.dyyhub.bookCity.pojo.User;
import com.dyyhub.bookCity.service.CartItemService;
import com.dyyhub.bookCity.service.CartService;
import com.dyyhub.bookCity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    @Qualifier("UserService")
    UserService userService;

    @Autowired
    @Qualifier("cartService")
    CartService cartService;


    //查询所有user
    @RequestMapping("/findAll")
    public ModelAndView findAll(ModelAndView modelAndView){
        List<User> userList = userService.findAll();
        modelAndView.addObject("user",userList);
        modelAndView.setViewName("test");
        return modelAndView;
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String loginByNameAndPWD(String username , String password, HttpSession session){
        User user = userService.login(username,password);
        if(user != null){
            Cart cart = cartService.getCartByUser(user);
            user.setCart(cart);
            session.setAttribute("currUser",user);
            return "redirect:/index";
//            return "/user/login_success";
        }
        return "/user/login";
    }
}
