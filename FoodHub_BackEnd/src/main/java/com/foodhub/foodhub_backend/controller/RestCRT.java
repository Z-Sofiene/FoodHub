package com.foodhub.foodhub_backend.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.foodhub.foodhub_backend.dao.*;
import com.foodhub.foodhub_backend.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class RestCRT {

    @Autowired
    private RestaurantDao restaurantDao;
    @Autowired
    private ItemMenuDao itemMenuDao;
    @Autowired
    private CommandeDao commandeDao;
    @Autowired
    private LigneCdeDao ligneCdeDao;
    @Autowired
    private IUser userDao ;

    @RequestMapping(value = "/login", method = {RequestMethod.POST, RequestMethod.GET})
    public String preLogin(@RequestParam(value = "error", required = false) String error , Model model) {

        String msg = null;
        if (error != null) {
            msg = "Username or Password is incorrect !!";
        }

        model.addAttribute("errorMessge", msg);
        return "login";
    }



    @GetMapping("/verif/{username}/{password}")
    public User verifyUser(@PathVariable String username, @PathVariable String password) {
        User user = userDao.findByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    @GetMapping("/restaurant/liste")
    public List<Restaurant> getAllRestaurants() {
        return restaurantDao.findAll();
    }

    @GetMapping("/restaurant/{id}")
    public Restaurant getRestaurantById(@PathVariable int id) {
        return restaurantDao.findById(id).orElse(null);
    }

    @PutMapping("/restaurant/update")
    public Restaurant updateRestaurant(@RequestBody Restaurant Restaurant) {
        return restaurantDao.save(Restaurant);
    }

    /*
    @PostMapping("/restaurant/add")
    public Restaurant addRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantDao.save(restaurant);
    }
    */
    @PostMapping("/restaurant/add")
    public void addRestaurant(@RequestParam("file") MultipartFile file,
                           @RequestParam("restaurant") String restaurant){
        try {
            if(!file.isEmpty()){

                Restaurant r = new ObjectMapper().readValue(restaurant, Restaurant.class);
                byte[] image = file.getBytes();
                restaurantDao.save(new Restaurant(image,r.getTitre(),r.getDescription(),r.getAdresse(),r.getSpecialite()));
                /*
                Restaurant r = new ObjectMapper().readValue(restaurant, Restaurant.class);
                r.setImage(file.getBytes());
                restaurantDao.save(r);

                 */
            }
        } catch (Exception ignored) { }
    }


    @DeleteMapping("/restaurant/delete/{id}")
    public void deleteRestaurant(@PathVariable int id) {
        restaurantDao.deleteById(id);
    }

    @GetMapping("/restaurant/menu/{id}")
    public List<ItemMenu> getItemMenus(@PathVariable int id) {
        return itemMenuDao.findByRestId(id);
    }

    @PostMapping("/menu/add")
    public void addMenu(@RequestParam("file") MultipartFile file,
                           @RequestParam("menu") String menu){
        try {
            if(!file.isEmpty()){
                ItemMenu m = new ObjectMapper().readValue(menu, ItemMenu.class);
                byte[] image = file.getBytes();
                itemMenuDao.save(new ItemMenu(m.getTitre(),m.getDescription(),m.getPrix(),image,m.getRest()));
            }
        } catch (Exception ignored) { }
    }

    @DeleteMapping("/menu/delete")
    public void deleteItemMenu(@RequestBody ItemMenu item) {
        itemMenuDao.delete(item);
    }

    @DeleteMapping("deleteItem/{id}")
    public void deleteItem(@PathVariable int id) {
        itemMenuDao.deleteById(id);
    }
    @GetMapping("/commande/liste/{id}")
    public List<Commande> getCommandes(@PathVariable int id) {
        return commandeDao.findByUserId(id);
    }

    @DeleteMapping("/commande/delete/{id}")
    public void deleteCommande(@PathVariable int id) {
        commandeDao.deleteById(id);
    }

    @PostMapping("/commande/add/{idUser}")
    public void addCommande(@PathVariable int idUser, @RequestBody Commande cde) {
        User u = userDao.findById(idUser).get();
        cde.setUser(u);
        commandeDao.save(cde);
    }
}