package com.dyyhub.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class accountController {

    @Value("{spring.datasource.url}")
    private String url;

    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        return url;
    }


    @RequestMapping
    public String index() {
        return "SpringBoot is running";
    }


}
