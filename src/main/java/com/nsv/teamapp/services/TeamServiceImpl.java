package com.nsv.teamapp.services;

import com.nsv.teamapp.domains.Team;
import com.nsv.teamapp.repositories.TeamDAO;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(propagation = Propagation.REQUIRES_NEW)
@Service
public class TeamServiceImpl implements TeamService {

    private static final Logger LOGGER = Logger.getLogger(TeamServiceImpl.class);

    @Autowired
    private TeamDAO teamDAO;

    @Override
    public void createTeam(Team team) {
        LOGGER.info("Manual Logging-createTeam-BEGIN" + team);
        teamDAO.createOrUpdate(team);
        LOGGER.info("Manual Logging-createTeam-END" + team);
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
    public void deleteTeam(int id) {
        LOGGER.info("Manual Logging-deleteTeam-BEGIN" + id);
        teamDAO.delete(id);
        LOGGER.info("Manual Logging-deleteTeam-END" + id);
    }

    @Override
    public List<Team> getAllTeams() {
        LOGGER.info("Manual Logging-getAllTeams-BEGIN");
        LOGGER.info("Manual Logging-getAllTeams-END");
        return teamDAO.getAll();

    }
}
