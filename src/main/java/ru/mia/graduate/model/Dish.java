package ru.mia.graduate.model;


import javax.persistence.*;

@Entity
@Table(name="Dish")
public class Dish {

    private int restaurant_Id;

    @Column(name="name")
    private String name;

    @Column(name="price")
    private float price;
}
