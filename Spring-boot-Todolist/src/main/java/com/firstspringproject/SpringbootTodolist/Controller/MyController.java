package com.firstspringproject.SpringbootTodolist.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

   // @RequestMapping(value="/" , method = RequestMethod.GET)
    @GetMapping("/")
    public String helloWorld(){
        return "Welcome Rest Controller";
    }


}
