package ru.mia.graduate.model;


import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    int id;

    @Column(name="name")
    String name;

    @Column(name="vote_restaurant")
    int vote_restaurant;

    @Column(name="vote_time")
    String vote_time;


    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Role> roles;

    public int getVote_restaurant() {return vote_restaurant;}

    public void setVote_restaurant(int vote_restaurant) {this.vote_restaurant = vote_restaurant;}

    public String getVote_time() {return vote_time;}

    public void setVote_time(String vote_time) {this.vote_time = vote_time;}


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

    public User(String name) {
        this.name = name;
    }

    public void setRoles(Collection<Role> roles) {
        //this.roles = CollectionUtils.isEmpty(roles) ? Collections.emptySet() : EnumSet.copyOf(roles);
    }
    public Set<Role> getRoles() {
        return roles;
    }
    public User(String name, Collection<Role> roles) {

        this.name =name;
        setRoles(roles);
    }
}
