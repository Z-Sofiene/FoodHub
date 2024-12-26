package com.foodhub.foodhub_backend.model;



import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titre;
    private String description;
    private String adresse;
    private String specialite;
    @Lob
    private byte[] image;
    @JsonManagedReference
	@OneToMany(mappedBy = "rest", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<ItemMenu> menu;

    public Restaurant() {
    }

    public Restaurant(Integer id, String titre, String description, String adresse, String specialite, List<ItemMenu> menu) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.adresse = adresse;
        this.specialite = specialite;
        this.menu = menu;
    }

    public Restaurant(Integer id, String titre, String description, String adresse, String specialite) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.adresse = adresse;
        this.specialite = specialite;
        this.menu = new ArrayList<ItemMenu>();
    }
    public Restaurant(byte[] image, String titre, String description, String adresse, String specialite) {
        this.image = image;
        this.titre = titre;
        this.description = description;
        this.adresse = adresse;
        this.specialite = specialite;
        this.menu = new ArrayList<ItemMenu>();
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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public List<ItemMenu> getMenu() {
        return menu;
    }

    public void setMenu(List<ItemMenu> menu) {
        this.menu = menu;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
