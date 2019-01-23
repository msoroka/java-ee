package com.msoroka.javaee.projekt.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.Date;

@StaticMetamodel(Plane.class)
public class Plane_ {

    public static volatile SingularAttribute<Plane, String> model;
    public static volatile SingularAttribute<Plane, String> sideNumber;
    public static volatile SingularAttribute<Plane, Date> produceDate;
    public static volatile SingularAttribute<Plane, Integer> capacity;

}
