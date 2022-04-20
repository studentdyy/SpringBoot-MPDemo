package com.dyyhub.bookCity.controller;

import com.dyyhub.bookCity.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    @Qualifier("bookService")
    BookService bookService;

}
