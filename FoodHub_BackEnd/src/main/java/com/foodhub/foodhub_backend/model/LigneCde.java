package com.foodhub.foodhub_backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class LigneCde {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private ItemMenu item;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "cde_id")
    private Commande cde;

    public LigneCde() {
    }

    public LigneCde(Integer id, ItemMenu item, Commande cde) {
        this.id = id;
        this.item = item;
        this.cde = cde;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ItemMenu getItem() {
        return item;
    }

    public void setItem(ItemMenu item) {
        this.item = item;
    }

    public Commande getCde() {
        return cde;
    }

    public void setCde(Commande cde) {
        this.cde = cde;
    }
}
