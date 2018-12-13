package pl.msoroka.javaee.zad06.service;

import pl.msoroka.javaee.zad06.domain.Plane;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class PlaneManager {

    @PersistenceContext(unitName= "demoPU")
    private EntityManager em;

    public void addPlane(Plane plane) {
        em.persist(plane);
    }

    public Plane getPlane(int id){
        return em.find(Plane.class, id);
    }

    public Plane updatePlane(Plane transientPlane) {
        return em.merge(transientPlane);
    }

    public void deleteAllPlanes(){
        em.createNamedQuery("plane.deleteAll").executeUpdate();
    }

    @SuppressWarnings("unchecked")
    public List<Plane> getAllPlanes(){
        return em.createNamedQuery("plane.getAll").getResultList();
    }
}
