package com.msoroka.javaee.projekt.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PlaneManager {

    @PersistenceContext
    EntityManager em;

}
