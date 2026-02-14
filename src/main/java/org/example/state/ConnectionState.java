package org.example.state;

import org.example.entity.User;

public interface ConnectionState {
    void notifyUser(User user);
}
