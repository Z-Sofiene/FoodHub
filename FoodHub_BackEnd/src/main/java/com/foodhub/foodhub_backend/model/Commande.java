package com.foodhub.foodhub_backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Commande {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @JsonManagedReference
    @OneToMany(mappedBy = "cde", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<LigneCde> items;


    public Commande() {
    }

    public Commande(Integer id, String date, User user) {
        this.id = id;
        this.date = date;
        this.user = user;
        this.items = new ArrayList<LigneCde>();
    }

    public Commande(Integer id, String date, User user, List<LigneCde> items) {
        this.id = id;
        this.date = date;
        this.user = user;
        this.items = items;
    }



    private void addItem(LigneCde li){
        li.setCde(this);
        this.items.add(li);
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<LigneCde> getItems() {
        return items;
    }

    public void setItems(List<LigneCde> items) {
        this.items = items;
    }
}
