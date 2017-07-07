package com.example.demo.Models;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

/**
 * Created by student on 6/28/17.
 */

@Entity

public class Skills {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String level;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable
    private Set<User> users;


    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

}