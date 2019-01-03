package com.example.restejbjpa.service;

import com.example.restejbjpa.domain.Dog;
import com.example.restejbjpa.domain.Person;

import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class DogService {

    @PersistenceContext(unitName= "demoPU")
    EntityManager em;

    public void addDog(Dog dog) {
        //magic start

        em.persist(dog);

        //em.detach(dog); // odłączy nasłuchwianie
        //dog.setName("Cywil"); //zadziała bo są nasłuchiwane zmiany

        //magic stop
    }


    public Dog findDogById(long id) {
        return em.find(Dog.class, id);
    }
}
