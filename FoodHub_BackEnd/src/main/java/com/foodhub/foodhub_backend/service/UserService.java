package com.foodhub.foodhub_backend.service;

import com.foodhub.foodhub_backend.dao.IUser;
import com.foodhub.foodhub_backend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService implements UserDetailsService {

	@Autowired
	private IUser daoUser;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public User loadUserByUsername(String username) throws UsernameNotFoundException {
		return daoUser.findByUsername(username);
	}

	public User addUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return daoUser.save(user);
	}

	public String cryptage(String password) {
		return passwordEncoder.encode(password);
	}
}
