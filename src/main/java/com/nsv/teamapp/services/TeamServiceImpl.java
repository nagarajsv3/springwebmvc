package com.nsv.teamapp.services;

import com.nsv.teamapp.domains.Team;
import com.nsv.teamapp.repositories.TeamDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamDAO teamDAO;

    @Override
    public void createTeam(Team team) {
        teamDAO.createOrUpdate(team);
    }

    @Override
    public Team getTeamById(int id) {
        return teamDAO.getById(id);
    }

    @Override
    public void updateTeam(Team team) {
        teamDAO.createOrUpdate(team);

    }

    @Override
    public void deleteTeam(Team team) {
        teamDAO.delete(team);
    }

    @Override
    public List<Team> getAllTeams() {
        return teamDAO.getAll();
    }
}
