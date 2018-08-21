package com.nsv.teamapp.repositories;

import com.nsv.teamapp.domains.Team;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class TeamDAO {
    
    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    @Transactional(isolation = Isolation.DEFAULT, rollbackFor = RuntimeException.class, propagation = Propagation.REQUIRED)
    public void createOrUpdate(Team team){
        getSession().saveOrUpdate(team);
        getSession().flush();
    }


    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.SUPPORTS)
    public Team getById(int id){
        Team team = (Team) getSession().get(Team.class, id);
        return team;
    }

    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.SUPPORTS)
    public List<Team> getAll(){
        List<Team> teams= getSession().createCriteria(Team.class).list();
        return teams;
    }

    @Transactional(isolation = Isolation.DEFAULT, rollbackFor = RuntimeException.class, propagation = Propagation.REQUIRED)
    public void delete(int id){
        Team byId = getById(id);
        getSession().delete(byId);
        getSession().flush();
    }

    @Transactional(isolation = Isolation.DEFAULT, rollbackFor = RuntimeException.class, propagation = Propagation.REQUIRES_NEW)
    public void updateAndDelete(int id){
        createOrUpdate(getById(id));
        delete(id);
    }

}
