package com.nsv.teamapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String loadTestPage1(){
        return "test";
    }

    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    public String loadTestPage2(){
        return "test";
    }
}
