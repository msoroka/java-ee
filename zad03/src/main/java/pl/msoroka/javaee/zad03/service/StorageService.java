package pl.msoroka.javaee.zad03.service;

import java.util.ArrayList;
import java.util.List;

import pl.msoroka.javaee.zad03.domain.Plane;

public class StorageService {

    private int id = 0;
    private List<Plane> db = new ArrayList<Plane>();
    private List<Plane> cart = new ArrayList<Plane>();

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

}
