package com.example.restejbjpa.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@NamedQueries({
    @NamedQuery(name = "person.getCarsOfPerson", query = "Select c from Person p JOIN p.cars c where p.id = :pId")
})
@Entity
public class Person {

    private Long id;

    private String firstName;

    private String lastName;

    private int yob;

//    private List<Dog> dogs;

    private List<Car> cars = new ArrayList<>();

    public Person(String firstName, String lastName, int yob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.yob = yob;
    }

    public Person(Long id, String firstName, int yob) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.yob = yob;
    }

    public Person() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getYob() {
        return yob;
    }

    public void setYob(int yob) {
        this.yob = yob;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    public List<Dog> getDogs() {
//        return dogs;
//    }
//
//    public void setDogs(List<Dog> dogs) {
//        this.dogs = dogs;
//    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public void addCars(List<Car> cars){
        this.cars = cars;

        for(Car car: cars) {
            car.getOwners().add(this);
        }
    }
}
