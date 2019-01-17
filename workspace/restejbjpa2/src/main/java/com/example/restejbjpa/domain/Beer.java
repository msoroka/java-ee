package com.example.restejbjpa.domain;

import javax.persistence.*;

@Entity
@NamedQuery(name = "beer.getOldBeer", query = "SELECT b FROM Beer b WHERE b.yop < :yop")
public class Beer {

    private long id;
    private String name;
    private int yop;

    public Beer(String name, int yop) {
        this.name = name;
        this.yop = yop;
    }

    public Beer() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYop() {
        return yop;
    }

    public void setYop(int yop) {
        this.yop = yop;
    }
}
