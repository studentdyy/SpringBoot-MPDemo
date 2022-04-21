package com.dyyhub.bookCity.controller;

import com.dyyhub.bookCity.pojo.Cart;
import com.dyyhub.bookCity.pojo.OrderBean;
import com.dyyhub.bookCity.pojo.User;
import com.dyyhub.bookCity.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping("/checkout")
    public  String checkOut(HttpSession session){
        User user = (User)session.getAttribute("currUser");
        orderService.addOrderBean(user);
        return "forward:/index";
    }

    @RequestMapping("list")
    public  String list(HttpServletRequest request,HttpSession session){
        User user = (User)session.getAttribute("currUser");
        List<OrderBean> orderBeanList = orderService.showOrderBeanList(user.getId());
        request.setAttribute("orderBeanList",orderBeanList);
        return "order/order";
    }
}
