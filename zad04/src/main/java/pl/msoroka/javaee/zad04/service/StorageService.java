package pl.msoroka.javaee.zad04.service;

import java.util.ArrayList;
import java.util.List;

import pl.msoroka.javaee.zad04.domain.Plane;

public class StorageService {

    private int id = 0;
    private List<Plane> db = new ArrayList<Plane>();
    private List<Plane> cart = new ArrayList<Plane>();
    private boolean rodo;

    public void add(Plane plane) {
        Plane newPlane = new Plane(plane.getId(), plane.getProducer(), plane.getProductionDate(), plane.getCombustion(), plane.isVipStatus(), plane.getPrice(), plane.getQuantity());
        db.add(newPlane);
    }

    public int getId() {
        id++;

        return this.id;
    }

    public List<Plane> getAllPlanes() {
        return db;
    }

    public void addToCart(Plane plane) {
        cart.add(plane);
    }

    public List<Plane> getCart() {
        return cart;
    }

    public void setRodoStatus(String rodo) {
        if("on".equals(rodo)) {
            this.rodo = true;
        } else {
            this.rodo = false;
        }
//
    }

    public boolean getRodoStatus() {
        return rodo;
    }
}
