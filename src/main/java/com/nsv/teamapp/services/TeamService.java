package com.nsv.teamapp.services;

import com.nsv.teamapp.domains.Team;

import java.util.List;

public interface TeamService {

    public void createTeam(Team team);
    public Team getTeamById(int id);
    public void updateTeam(Team team);
    public void deleteTeam(Team team);
    public List<Team> getAllTeams();

}
