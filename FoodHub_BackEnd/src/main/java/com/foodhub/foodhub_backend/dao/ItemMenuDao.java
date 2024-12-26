package com.foodhub.foodhub_backend.dao;

import com.foodhub.foodhub_backend.model.ItemMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemMenuDao extends JpaRepository<ItemMenu,Integer> {
    public List<ItemMenu> findByRestId(int rest_id);
}