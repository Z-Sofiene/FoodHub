package com.foodhub.foodhub_backend.dao;

import com.foodhub.foodhub_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface IUser extends JpaRepository<User, Integer> {
	
	
	User findByUsername(String username);
	

}
