package com.foodhub.foodhub_backend.dao;

import com.foodhub.foodhub_backend.model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommandeDao extends JpaRepository<Commande,Integer> {

    public List<Commande> findByUserId(int id);
}
