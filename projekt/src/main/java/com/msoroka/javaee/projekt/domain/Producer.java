package com.msoroka.javaee.projekt.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "producer.getAll", query = "Select p from Producer p"),
        @NamedQuery(name = "producer.getPlanesOfProducer", query = "Select pl from Producer p JOIN p.planes pl where p.id = :pId"),
        @NamedQuery(name = "producer.getProducerPlanes", query = "Select p.name, pl.model FROM Producer p JOIN p.planes pl WHERE p.name = :name")
})
public class Producer {

    private long id;
    private String name;
    private Date yoe;

    @JsonManagedReference
    private List<Plane> planes = new ArrayList<Plane>();

    public Producer(String name, Date yoe) {
        this.name = name;
        this.yoe = yoe;
    }

    public Producer() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @Temporal(TemporalType.DATE)
    public Date getYoe() {
        return yoe;
    }

    public void setYoe(Date yoe) {
        this.yoe = yoe;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producer", fetch = FetchType.EAGER)
    public List<Plane> getPlanes() {
        return planes;
    }

    public void setPlanes(List<Plane> planes) {
        this.planes = planes;
    }
}
