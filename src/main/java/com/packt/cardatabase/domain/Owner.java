package com.packt.cardatabase.domain;
import javax.persistence.*;
import java.util.List;

@Entity
public class Owner {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long ownerid;
    private String firstName, lastName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="owner")
    private List<Car> cars;

    public Owner() {}

    public Owner(String firstName, String lastName) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public long getOwnerid() {
        return ownerid;
    }
    public void setOwnerid(long ownerid) {
        this.ownerid = ownerid;
    }
    public String getfirstName() {
        return firstName;
    }
    public void setfirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getlastName() {
        return lastName;
    }
    public void setlastName(String lastName) {
        this.lastName = lastName;
    }
}