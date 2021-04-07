package com.project.project1.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Dormitory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "Please enter the name of the dormitory")
    private String name;

    @NotNull(message = "Please enter the address!")
    private String address;

    @Min(value = 100, message = "The minimum accepted capacity is 100")
    private int capacity;

public Dormitory(){}

@OneToMany(mappedBy = "studDormitory", cascade = CascadeType.ALL)
    List<Student> accomodatedStudents;

public Dormitory(int id, String name, String address, int capacity) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.capacity = capacity;
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Student> getAccomodatedStudents() {
        return accomodatedStudents;
    }

    public void setAccomodatedStudents(List<Student> accomodatedStudents) {
        this.accomodatedStudents = accomodatedStudents;
    }

    @Override
    public String toString() {
        return "Dormitory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
