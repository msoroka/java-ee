package pl.msoroka.javaee.zad06.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@Entity
@NamedQueries({
        @NamedQuery(name = "plane.getAll", query = "Select p from Plane p"),
        @NamedQuery(name = "plane.deleteAll", query="Delete from Plane ")
})
public class Plane {
    private int id;
    private String name;
    private String produceDate;
    private int capacity;
    private double combustion;

    private List<Producer> producers = new ArrayList<>();

    public Plane(String name, String produceDate, int capacity, double combustion) {
        this.name = name;
        this.produceDate = produceDate;
        this.capacity = capacity;
        this.combustion = combustion;
    }

    public Plane() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProduceDate() {
        return produceDate;
    }

    public void setProduceDate(String produceDate) {
        this.produceDate = produceDate;
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
//
//    @ManyToMany(mappedBy = "planes", fetch = FetchType.EAGER)
//    public List<Producer> getProducers() {
//        return producers;
//    }
//
//    public void setProducers(List<Producer> producers) {
//        this.producers = producers;
//    }
}
