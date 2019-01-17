package com.example.restejbjpa.service;

import com.example.restejbjpa.domain.Beer;
import com.example.restejbjpa.domain.Beer_;

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
public class BeerManager {

    @PersistenceContext
    EntityManager em;

    public void add() {
        Beer b1 = new Beer("Harnaś", 2015);
        Beer b2 = new Beer("Perłą", 2011);
        Beer b3 = new Beer("Lech", 2010);
        Beer b4 = new Beer("Wojak", 2012);

        em.persist(b1);
        em.persist(b2);
        em.persist(b3);
        em.persist(b4);
    }

    public List<Beer> getOldBeer(int yop) {
//        return em.createNamedQuery("beer.getOldBeer").setParameter("yop", yop).getResultList();

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();

        CriteriaQuery<Beer> beerCriteriaQuery = criteriaBuilder.createQuery(Beer.class);

        Root<Beer> beerRoot = beerCriteriaQuery.from(Beer.class);

//        Predicate predicate = criteriaBuilder.lt(beerRoot.get("yop"), yop);

        Predicate predicate = criteriaBuilder.lt(beerRoot.get(Beer_.yop), yop);

        beerCriteriaQuery.where(predicate);

        TypedQuery<Beer> beerTypedQuery = em.createQuery(beerCriteriaQuery);

        return beerTypedQuery.getResultList();
    }

}
