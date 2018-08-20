package com.nsv.teamapp.controllers;

import com.nsv.teamapp.domains.Team;
import com.nsv.teamapp.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/team")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public ModelAndView loadAddTeamPage(){
        //return "add";
        ModelAndView modelAndView = new ModelAndView("add");
        modelAndView.addObject("team",new Team());
        return modelAndView;
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public ModelAndView addTeamPage(@ModelAttribute Team team){
        teamService.createTeam(team);
        ModelAndView modelAndView = new ModelAndView("index");
        String message = "Team is added to the database";
        modelAndView.addObject("message",message);
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{teamid}",method = RequestMethod.GET)
    public ModelAndView loadEditTeamPage(@PathVariable("teamid") Long teamid){
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("team",new Team());
        return modelAndView;
    }

    @RequestMapping(value = "/update/{teamid}",method = RequestMethod.POST)
    public ModelAndView performEditTeamOps(@PathVariable("teamid") int teamid, Team team){
        Team teamById = teamService.getTeamById(teamid);
        System.out.println(teamById.getName());
        System.out.println(teamById);
        teamById.update(team);
        teamService.updateTeam(teamById);

        ModelAndView modelAndView = new ModelAndView("index");
        String message = "Team is updated";
        modelAndView.addObject("message",message);
        return modelAndView;
    }

    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public ModelAndView performDeleteTeamOps(@RequestParam("teamid") int teamid){
        teamService.deleteTeam(teamid);

        ModelAndView modelAndView = new ModelAndView("index");
        String message = "Team is Deleted";
        modelAndView.addObject("message",message);
        return modelAndView;
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ModelAndView loadListTeamsPage(){
        ModelAndView modelAndView = new ModelAndView("list");
        List<Team> teams = teamService.getAllTeams();
        modelAndView.addObject("teams",teams);
        return modelAndView;

    }

}
