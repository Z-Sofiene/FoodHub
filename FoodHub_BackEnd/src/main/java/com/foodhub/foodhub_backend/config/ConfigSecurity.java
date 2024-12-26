package com.foodhub.foodhub_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class ConfigSecurity  extends WebSecurityConfigurerAdapter  {
	
	@Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }
	
    @Bean
    Filter Filter() { 
    	return new Filter();      
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
       
    	http.cors().and().csrf().disable()
    	.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    	http.authorizeRequests().antMatchers("/auth/**","/api/restaurant/liste", "/api/restaurant/menu/**").permitAll();
    	http.authorizeRequests().anyRequest().authenticated();
    	http.addFilterBefore(Filter(), UsernamePasswordAuthenticationFilter.class);
	   
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
