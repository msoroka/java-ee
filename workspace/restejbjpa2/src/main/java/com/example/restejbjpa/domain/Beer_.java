package com.example.restejbjpa.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Beer.class)
public class Beer_ {

    public static volatile SingularAttribute<Beer, Integer> yop;
    public static volatile SingularAttribute<Beer, String> name;

}
