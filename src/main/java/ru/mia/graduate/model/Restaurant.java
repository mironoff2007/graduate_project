package ru.mia.graduate.model;


import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Restaurant {

    private int id;
    private String name;
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
