package com.msoroka.javaee.projekt.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@Entity
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "license.getAll", query = "Select l from License l"),
        @NamedQuery(name = "license.deleteAll", query = "Delete from License"),
})
public class License {

    private long id;
    private String number;
    private Date grantingDate;

    public License(String number, Date grantingDate) {
        this.number = number;
        this.grantingDate = grantingDate;
    }

    public License() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(unique = true, nullable = false)
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Temporal(TemporalType.DATE)
    public Date getGrantingDate() {
        return grantingDate;
    }

    public void setGrantingDate(Date grantingDate) {
        this.grantingDate = grantingDate;
    }
}
