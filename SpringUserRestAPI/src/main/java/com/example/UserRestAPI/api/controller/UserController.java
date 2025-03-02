package com.example.UserRestAPI.api.controller;

import com.example.UserRestAPI.model.User;
import com.example.UserRestAPI.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/users")
public class UserController {
    UserService userService;

    public UserController() {
        this.userService = new UserService();

    }

    public UserService getUserService() {
        return userService;
    }
    @GetMapping("/{id}")
    public User getUser(@PathVariable Integer id){
        Optional user = this.userService.getUser(id);
        if(user.isPresent()){
            return (User) user.get();
        }else{
            return null;
        }
    }
    @GetMapping
    public List<User> getUsers(){
        List<User> users = this.userService.getUsers();
        return users;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addUser(@RequestBody User user) {
        System.out.println("Adding user: " + user);
        this.userService.createUser(user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable Integer id){
        System.out.println("Deleting user with ID: " + id);
        this.userService.deleteUser(id);
    }

}
