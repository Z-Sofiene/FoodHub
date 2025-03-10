package com.foodhub.foodhub_backend.dao;

import com.foodhub.foodhub_backend.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface IRole extends JpaRepository<Role, Integer> {

}
