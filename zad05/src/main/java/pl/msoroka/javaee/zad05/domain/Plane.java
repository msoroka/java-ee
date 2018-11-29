package pl.msoroka.javaee.zad05.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Plane {

    private String producer;
    private int capacity;
    private double combustion;

    public Plane() {
    }

    public Plane(String producer, int capacity, double combustion) {
        this.producer = producer;
        this.capacity = capacity;
        this.combustion = combustion;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getCombustion() {
        return combustion;
    }

    public void setCombustion(double combustion) {
        this.combustion = combustion;
    }
}
