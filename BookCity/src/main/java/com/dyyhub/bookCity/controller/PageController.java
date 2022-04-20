package com.dyyhub.bookCity.controller;

import com.dyyhub.bookCity.pojo.Book;
import com.dyyhub.bookCity.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("")
public class PageController {

    @Autowired
    BookService bookService;

    @RequestMapping("/login")
    public String loginPage(){ return "/user/login"; }

    @RequestMapping("/index")
    public ModelAndView indexPage(ModelAndView modelAndView){

        List<Book> bookList = bookService.getBookList();
        modelAndView.addObject("bookList",bookList);
        modelAndView.setViewName("index");
        return modelAndView;


    }
//    @RequestMapping("/cart")
//    public String cartPage(){
//        return "cart/cart";
//    }
}
