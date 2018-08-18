package com.nsv.teamapp.repositories;

import com.nsv.teamapp.domains.Team;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeamDAO {
    
    @Autowired
    private SessionFactory sessionFactory;
    
    public void createOrUpdate(Team team){
        Session session = sessionFactory.openSession();
        session.save(team);
        session.close();
    }

    public Team getById(int id){
        Session session = sessionFactory.openSession();
        Team team = session.load(Team.class, id);
        session.close();
        return team;
    }

    public List<Team> getAll(){
        Session session = sessionFactory.openSession();
        List<Team> teams= session.createCriteria(Team.class).list();
        session.close();
        return teams;
    }

    public void delete(Team team){
        Session session = sessionFactory.openSession();
        session.delete(team);
        session.close();
    }





}
