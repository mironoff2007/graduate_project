package ru.mia.graduate.model;



import javax.persistence.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Entity
@Table(name="Restaurant")
public class Restaurant {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;
    @Column(name="votes")
    private AtomicInteger votes;

    private List<Integer> dishes ;

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

    public AtomicInteger getVotes() {
        return votes;
    }

    public void addVotes() {
        this.votes.incrementAndGet();
    }

    public void removeVotes() {
        this.votes.decrementAndGet();
    }

    public List<Integer> getDishes() {
        return dishes;
    }

    public void setDishes(List<Integer> dishes) {
        this.dishes = dishes;
    }
}
