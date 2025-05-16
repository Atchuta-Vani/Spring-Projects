package com.example.BirdSightingSystem.DAO;

import com.example.BirdSightingSystem.model.User;

import java.util.List;
import java.util.Optional;

/**
 * Connects to MYSQL Schema mydb and retrieves information related to Users
 */
public class UserDAO {
    List<User> users = null;
    public UserDAO() {
        //JDBC connection and load driver to MySQL
    }

    public List<User> getUsers() {
        //Get from DAO and Database.
        //Select * from users table.

        return users;
    }

    public Optional<User> getUserById(Integer id) {
        Optional<User> user = Optional.empty();
        for (User user1 : users) {
            if (user1.getId() == id) {
                user = Optional.of(user1);
            }
        }
        return user;
    }
    public Optional<User> getUserByUserName(String username) {
        Optional<User> user = Optional.empty();
        for (User user1 : users) {
            if (user1.getUsername().equals(username) ) {
                user = Optional.of(user1);
            }
        }
        return user;
    }


}
