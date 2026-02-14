package org.example.observer;

import org.example.entity.Connection;

public interface ConnectionObserver {
    void notifyUser(Connection connection);
}
