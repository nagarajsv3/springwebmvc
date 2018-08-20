package com.nsv.teamapp.repositories;

import com.nsv.teamapp.domains.Team;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class TeamDAO {
    
    @Autowired
    private SessionFactory sessionFactory;

    public void create(Team team){
        Session session = sessionFactory.openSession();
        session.save(team);
        session.close();
    }

    public void update(Team team){
        Session session = sessionFactory.openSession();
        session.update(team);
        session.close();
    }

    public Team getById(int id){
        Session session = sessionFactory.openSession();
        Team team = (Team) session.load(Team.class, id);
        team.update(team);
        //session.update(team);
        session.close();
        return team;
    }

    public List<Team> getAll(){
        Session session = sessionFactory.openSession();
        List<Team> teams= session.createCriteria(Team.class).list();
        session.close();
        return teams;
    }

    public void delete(int id){
        Session session = sessionFactory.openSession();
        Team byId = getById(id);
        session.delete(byId);
        session.flush();
        session.close();
    }

}
