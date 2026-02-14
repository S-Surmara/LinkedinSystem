package org.example.service;

import org.example.entity.User;

import java.util.HashMap;
import java.util.Map;

public class AuthenticationService {
    private Map<String, User> registeredUsers;

    public AuthenticationService() {
        this.registeredUsers = new HashMap<>();
    }

    public boolean authenticateUser(String email, String password) {
        User user = registeredUsers.get(email);
        if (user != null && user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }

    public User registerUser(String name, String email, String password) {
        if (registeredUsers.containsKey(email)) {
            throw new IllegalArgumentException("User already exists");
        }
        User user = new User(name, email, password);
        registeredUsers.put(email, user);
        return user;
    }

    public User getUser(String email) {
        return registeredUsers.get(email);
    }
}
