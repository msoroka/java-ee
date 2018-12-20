package pl.msoroka.javaee.zad06.service;

import pl.msoroka.javaee.zad06.domain.Producer;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ProducerManager {

    @PersistenceContext
    private EntityManager em;

    public void addProducer(Producer producer) {
        em.persist(producer);
    }

    public Producer getProducer(int id){
        return em.find(Producer.class, id);
    }

    public Producer updateProducer(Producer transientProducer) {
        return em.merge(transientProducer);
    }

    public void deleteAllProducers(){
        em.createNamedQuery("producer.deleteAll").executeUpdate();
    }

    @SuppressWarnings("unchecked")
    public List<Producer> getAllProducers(){
        return em.createNamedQuery("producer.getAll").getResultList();
    }
}
