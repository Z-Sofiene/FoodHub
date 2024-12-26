package com.foodhub.foodhub_backend.dao;

import com.foodhub.foodhub_backend.model.LigneCde;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LigneCdeDao extends JpaRepository<LigneCde,Integer> {

}
