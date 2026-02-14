package org.example.persistance;

import org.example.entity.Connection;
import org.example.entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConnectionPersistence {
    private Map<User, List<User>> userConnections;

    public ConnectionPersistence() {
        this.userConnections = new HashMap<>();
    }

    public void saveConnection(Connection connection) {
        userConnections.computeIfAbsent(connection.getFrom(), k -> new ArrayList<>())
                .add(connection.getTo());
        userConnections.computeIfAbsent(connection.getTo(), k -> new ArrayList<>())
                .add(connection.getFrom());
    }

    public List<User> getConnections(User user) {
        return userConnections.getOrDefault(user, new ArrayList<>());
    }
}
