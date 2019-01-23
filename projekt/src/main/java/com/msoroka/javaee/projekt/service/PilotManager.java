package com.msoroka.javaee.projekt.service;

import com.msoroka.javaee.projekt.domain.Pilot;
import com.msoroka.javaee.projekt.domain.Plane;

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

    public Pilot getPilotByLicenseNumber(String licenseNumber){
        return (Pilot) em.createNamedQuery("pilot.byLicenseNumber").setParameter("number", licenseNumber).getSingleResult();
    }

    public Pilot updatePilot(Pilot transientPilot) {
        return em.merge(transientPilot);
    }

    @SuppressWarnings("unchecked")
    public List<Plane> getAllPlanesByLicenceNumber(String licenseNumber) {
        return em.createNamedQuery("pilot.getPlanesByLicenseNumber").setParameter("number", licenseNumber).getResultList();
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
