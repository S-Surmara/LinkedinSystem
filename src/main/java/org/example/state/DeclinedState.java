package org.example.state;

import org.example.entity.User;

public class DeclinedState implements ConnectionState {

    @Override
    public void notifyUser(User user) {
        System.out.println("Connection declined by: " + user.getName());
    }
}
