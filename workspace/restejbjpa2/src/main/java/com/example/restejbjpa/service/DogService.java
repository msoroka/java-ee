package com.example.restejbjpa.service;

import com.example.restejbjpa.domain.Dog;

import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class DogService {

    @PersistenceContext(unitName= "demoPU")
    EntityManager em;

    public void addDog(Dog dog) {

        em.persist(dog);

    }

}
