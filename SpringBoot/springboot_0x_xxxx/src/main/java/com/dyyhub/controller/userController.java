package com.dyyhub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class userController {

    //    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        return "delete users form id = " + id;
    }

    //    @RequestMapping(method = RequestMethod.POST)
    @PostMapping
    public String save() {
        return "{'key','values'}";
    }


}
