package com.nsv.teamapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("/get")
    public String loadHelloPage(){
        return "hello";
    }
}
