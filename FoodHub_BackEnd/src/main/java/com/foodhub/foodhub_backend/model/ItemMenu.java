package com.foodhub.foodhub_backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;

@Entity
public class ItemMenu {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titre;
    private String description;
    private float prix;
    @Lob
    private byte[] image;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rest_id")
    private Restaurant rest;

    public ItemMenu() {
    }

    public ItemMenu(Integer id, String titre, String description, float prix, Restaurant rest) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.prix = prix;
        this.rest = rest;
    }



    public ItemMenu(String titre, String description, float prix, byte[] image, Restaurant rest) {

        this.titre = titre;
        this.description = description;
        this.prix = prix;
        this.image = image;
        this.rest = rest;
    }


    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public Restaurant getRest() {
        return rest;
    }

    public void setRest(Restaurant rest) {
        this.rest = rest;
    }
}
