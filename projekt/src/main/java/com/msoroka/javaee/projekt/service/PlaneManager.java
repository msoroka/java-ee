package com.msoroka.javaee.projekt.service;

import com.msoroka.javaee.projekt.domain.Plane;
import com.msoroka.javaee.projekt.domain.Plane_;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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

    @SuppressWarnings("unchecked")
    public List<Plane> getPlanesByProducerName(String name){
        return em.createNamedQuery("plane.getByProducerName").setParameter("name", name).getResultList();
    }

    public Plane getPlaneByModelName(String model){
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();

        CriteriaQuery<Plane> planeCriteriaQuery = criteriaBuilder.createQuery(Plane.class);

        Root<Plane> planeRoot = planeCriteriaQuery.from(Plane.class);

        Predicate predicate = criteriaBuilder.equal(planeRoot.get(Plane_.model), model);

        planeCriteriaQuery.where(predicate);

        TypedQuery<Plane> planeTypedQuery = em.createQuery(planeCriteriaQuery);

        return planeTypedQuery.getSingleResult();
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
