package org.example.state;

import org.example.entity.User;

public class RequestedState implements ConnectionState {

    @Override
    public void notifyUser(User user) {
        System.out.println("Connection request sent to: " + user.getName());
    }
}
