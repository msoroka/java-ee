package pl.msoroka.javaee.zad06.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@Entity
@NamedQueries({
        @NamedQuery(name = "producer.getAll", query = "Select p from Producer p"),
        @NamedQuery(name = "producer.deleteAll", query="Delete from Producer ")
})
public class Producer {

    private int id;
    private String name;
    private int yoe;

    private List<Plane> planes = new ArrayList<>();

    public Producer(String name, int yoe) {
        this.name = name;
        this.yoe = yoe;
    }

    public Producer() {
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

    public int getYoe() {
        return yoe;
    }

    public void setYoe(int yoe) {
        this.yoe = yoe;
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public List<Plane> getPlanes() {
        return planes;
    }

    public void setPlanes(List<Plane> planes) {
        this.planes = planes;
    }

    public void addPlanes(List<Plane> planes) {

        this.setPlanes(planes);

        for (Plane plane: planes){
            plane.getProducers().add(this);
        }
    }
}
