package com.msoroka.javaee.projekt.service;

import com.msoroka.javaee.projekt.domain.Pilot;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class PilotManager {

    @PersistenceContext
    EntityManager em;

    public void addPilot(Pilot pilot) {
        em.persist(pilot);
    }

    public Pilot getPilot(long id){
        return em.find(Pilot.class, id);
    }

    public Pilot updatePilot(Pilot transientPilot) {
        return em.merge(transientPilot);
    }

    public void deletePilot(long id){
        em.remove(em.find(Pilot.class, id));
    }

    public void deleteAllPilots(){
        em.createNamedQuery("pilot.deleteAll").executeUpdate();
    }

    @SuppressWarnings("unchecked")
    public List<Pilot> getAllPilots(){
        return em.createNamedQuery("pilot.getAll").getResultList();
    }
}
