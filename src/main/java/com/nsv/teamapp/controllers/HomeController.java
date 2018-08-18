package com.nsv.teamapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @RequestMapping(value="/",method = RequestMethod.GET)
    public String loadHomePage(){
        System.out.println("Received Load Home Page Request");
        return "index";
    }

    @RequestMapping(value="/hi",method = RequestMethod.GET)
    public String loadHiPage(){
        System.out.println("Received Load Hi Page Request");
        return "hi";
    }

}
