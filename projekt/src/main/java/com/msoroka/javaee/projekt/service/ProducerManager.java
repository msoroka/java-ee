package com.msoroka.javaee.projekt.service;

import com.msoroka.javaee.projekt.domain.Plane;
import com.msoroka.javaee.projekt.domain.Producer;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ProducerManager {

    @PersistenceContext
    EntityManager em;

    public void addProducer(Producer producer) {
        em.persist(producer);
    }

    public Producer getProducer(long id){
        return em.find(Producer.class, id);
    }

    public Producer updateProducer(Producer transientProducer) {
        return em.merge(transientProducer);
    }

    public void deleteProducer(long id){
        em.remove(em.find(Producer.class, id));
    }

    @SuppressWarnings("unchecked")
    public List<Producer> getAllProducers(){
        return em.createNamedQuery("producer.getAll").getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<Plane> getPlanesOfProducer(Long id) {
        List<Plane> planes = em.createNamedQuery("producer.getPlanesOfProducer").setParameter("pId", id).getResultList();

        return planes;
    }
}
