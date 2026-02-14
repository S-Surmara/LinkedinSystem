package org.example.state;

import org.example.entity.User;

public class PendingState implements ConnectionState {

    @Override
    public void notifyUser(User user) {
        System.out.println("Connection request pending for: " + user.getName());
    }
}
