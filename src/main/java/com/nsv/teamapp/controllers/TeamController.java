package com.nsv.teamapp.controllers;

import com.nsv.teamapp.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TeamController {

    @Autowired
    private TeamService teamService;
}
