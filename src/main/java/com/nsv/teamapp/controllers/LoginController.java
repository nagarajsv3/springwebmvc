package com.nsv.teamapp.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loadLoginPage(){
        return "login";
    }

    @RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
    public String loadAccessDeniedPage(){
        return "accessDenied";
    }

    //When user logsout kill the session
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String performLogout(HttpServletRequest request, HttpServletResponse response){
        //kill the session
        //load authentication object from Spring Security Context
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null){
            //perform a logout
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        return "redirect:/login";
    }


}
