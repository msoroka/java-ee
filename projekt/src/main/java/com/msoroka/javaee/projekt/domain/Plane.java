package com.msoroka.javaee.projekt.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@Entity
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "plane.getAll", query = "Select p from Plane p"),
        @NamedQuery(name = "plane.deleteAll", query = "Delete from Plane ")
})
public class Plane {

    private long id;
    private String model;
    private String sideNumber;
    private Date produceDate;
    private int capacity;

    public Plane(String model, String sideNumber, Date produceDate, int capacity) {
        this.model = model;
        this.sideNumber = sideNumber;
        this.produceDate = produceDate;
        this.capacity = capacity;
    }

    public Plane() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Column(unique = true, nullable = false)
    public String getSideNumber() {
        return sideNumber;
    }

    public void setSideNumber(String sideNumber) {
        this.sideNumber = sideNumber;
    }

    @Temporal(TemporalType.DATE)
    public Date getProduceDate() {
        return produceDate;
    }

    public void setProduceDate(Date produceDate) {
        this.produceDate = produceDate;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

}
