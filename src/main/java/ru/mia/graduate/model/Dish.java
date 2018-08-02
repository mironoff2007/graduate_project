package ru.mia.graduate.model;


import javax.persistence.*;

@Entity
@Table(name="dishes")
public class Dish {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="price")
    private float price;

    public Dish( String name, float price){
        this.id=id;
        this.name=name;
        this.price=price;
    }

    public Dish() {
    }
}
