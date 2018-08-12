package ru.mia.graduate.model;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="restaurants")
public class Restaurant {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;


    @OneToMany(cascade = CascadeType.ALL,
    orphanRemoval=true)
    @JoinColumn(name = "restaurant_id")
    private List<Dish> dishes ;


    public Restaurant() {
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


    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public void addDish(Dish dish){
        this.dishes.add(dish);
    }

    public Restaurant(String name)
    {
        this.name=name;
        dishes=new ArrayList<Dish>();
    }
}
