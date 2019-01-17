package com.msoroka.javaee.projekt.service;

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

    @SuppressWarnings("unchecked")
    public List<Producer> getAllProducers(){
        return em.createNamedQuery("producer.getAll").getResultList();
    }
}
