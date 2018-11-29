package pl.msoroka.javaee.zad05.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ejb.Singleton;

import pl.msoroka.javaee.zad05.domain.Plane;

@Singleton
public class PlaneManager {

    private List<Plane> db = Collections.synchronizedList(new ArrayList<>());

    public void addPlane(Plane plane) {
        db.add(plane);
    }

    public void deletePlane(Plane plane){
        db.remove(plane);
    }

    public Plane getPlane(Integer id) {
        return new Plane("Test endpoint id", 125, 25.0);
    }

    public List<Plane> getAllPlanes(){
        return db;
    }

    public void deleteAllPlanes(){
        db.clear();
    }

}
