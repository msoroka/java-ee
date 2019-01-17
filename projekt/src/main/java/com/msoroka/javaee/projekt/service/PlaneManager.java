package com.msoroka.javaee.projekt.service;

import com.msoroka.javaee.projekt.domain.Plane;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class PlaneManager {

    @PersistenceContext
    EntityManager em;

    public void addPlane(Plane plane) {
        em.persist(plane);
    }

    public Plane getPlane(long id){
        return em.find(Plane.class, id);
    }

    public Plane getPlaneBySideNumber(String sideNumber){
        return (Plane) em.createNamedQuery("plane.getBySideNumber").setParameter("sideNumber", sideNumber).getSingleResult();
    }

    public Plane updatePlane(Plane transientPlane) {
        return em.merge(transientPlane);
    }

    public void deletePlane(long id){
        em.remove(em.find(Plane.class, id));
    }

    public void deleteAllPlanes(){
        em.createNamedQuery("plane.deleteAll").executeUpdate();
    }

    @SuppressWarnings("unchecked")
    public List<Plane> getAllPlanes(){
        return em.createNamedQuery("plane.getAll").getResultList();
    }
}
