package com.example.BirdSightingSystem.service;

import com.example.BirdSightingSystem.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private List<User> users;

    public UserService() {
        users = new ArrayList<>();
        users.add(new User(1,"Vani Ch","","vani@gmail.com","123456789"));
        users.add(new User(2,"Rani M","","rani@gmail.com","123456789"));
        users.add(new User(3,"Bhanu M","","bhanu@gmail.com","123456789"));
        users.add(new User(4,"Yash C","","yash@gmail.com","123456789"));
        users.add(new User(5,"Manu C","","manu@gmail.com","123456789"));
        users.add(new User(6,"MM C","","mm@gmail.com","123456789"));

    }

    public Optional<User> getUser(Integer id) {
        Optional<User> user = Optional.empty();
        for (User user1 : users) {
            if (user1.getId() == id) {
                user = Optional.of(user1);
            }
        }
        return user;
    }

    public List<User> getUsers() {
        //Get from DAO and Database.
        return users;
    }

    public void createUser(User user) {
        users.add(user);
    }

    public void deleteUser(Integer id) {
        for (User user : users) {
            if (user.getId() == id) {
                users.remove(user);
                break;
            }
        }
    }

    public Optional<User> isValidUser(String userName, String password) {
        Optional<User> user = Optional.empty();
        for (User user1 : users) {
            if (user1.getUsername().equals(userName) && user1.getPassword().equals(password)) {
                user = Optional.of(user1);
            }
        }
        return user;
    }
}
