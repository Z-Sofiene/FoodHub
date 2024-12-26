package com.foodhub.foodhub_backend.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name="user")
public class User implements UserDetails {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id ;
	private String nom;
	private String username;
	private String password;

	private boolean enabled;

	@ManyToOne @JoinColumn(name = "role_id" )
	private Role role;

	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		List<GrantedAuthority> liste =new ArrayList<GrantedAuthority>();
		liste.add(new SimpleGrantedAuthority(role.getRole()));
		
		
		return liste;
	}
	
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return enabled;
	}
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public User(Integer id, String nom, String username, String password, boolean enabled, Role role) {
		super();
		this.id = id;
		this.nom = nom;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.role = role;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

}
