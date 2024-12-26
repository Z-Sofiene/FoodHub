package com.foodhub.foodhub_backend.controller;

import com.foodhub.foodhub_backend.config.GestionToken;
import com.foodhub.foodhub_backend.config.JwtRequest;
import com.foodhub.foodhub_backend.config.JwtResponse;
import com.foodhub.foodhub_backend.dao.IUser;
import com.foodhub.foodhub_backend.model.User;
import com.foodhub.foodhub_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


@CrossOrigin("*")
@RestController
@RequestMapping(value = "/auth")
public class RestAuth {

    @Autowired
    private GestionToken token_gen;

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private IUser userDao;

    @Autowired
    private ApplicationContext applicationContext;


    @PostMapping(value = "/login")
    public ResponseEntity<JwtResponse> signIn(@RequestBody JwtRequest request) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

            SecurityContextHolder.getContext().setAuthentication(authentication);

            User user = userService.loadUserByUsername(request.getUsername());
            String token = token_gen.generateToken(user);
            return ResponseEntity.ok(new JwtResponse(token));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new JwtResponse("Invalid credentials"));
        }
    }

    //work OK
    @PostMapping("/inscription")
    public void SignUp(@RequestBody User u) {
        PasswordEncoder cryptPassword = applicationContext.getBean(PasswordEncoder.class);
        u.setPassword(cryptPassword.encode(u.getPassword()));
        userDao.save(u);
    }
    //work OK
    @PostMapping("/signup")
    public void addUser2(@RequestBody User u) {
        u.setPassword(userService.cryptage(u.getPassword()));
        userDao.save(u);
        //userService.addUser(u); it works but it provide error 500
    }

    //provide error 500 but it works
    @PostMapping("/signup2")
    public User addUser(@RequestBody User u) {
        return userService.addUser(u);
    }

}
