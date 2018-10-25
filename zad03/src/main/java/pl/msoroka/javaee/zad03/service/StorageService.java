package pl.msoroka.javaee.zad03.service;

import java.util.ArrayList;
import java.util.List;

import pl.msoroka.javaee.zad03.domain.Plane;

public class StorageService {

    private List<Plane> db = new ArrayList<Plane>();

    public void add(Plane plane) {
        Plane newPlane = new Plane(plane.getProducer(), plane.getProductionDate(), plane.getCombustion(), plane.isVipStatus());
        db.add(newPlane);
    }

    public List<Plane> getAllPlanes() {
        return db;
    }

}
