package org.example.state;

import org.example.entity.User;

public class AcceptedState implements ConnectionState {

    @Override
    public void notifyUser(User user) {
        System.out.println("Connection accepted with: " + user.getName());
    }
}
