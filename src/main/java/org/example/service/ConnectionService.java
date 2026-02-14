package org.example.service;

import org.example.entity.Connection;
import org.example.entity.User;
import org.example.observer.ConnectionObserver;
import org.example.persistance.ConnectionPersistence;
import org.example.state.AcceptedState;
import org.example.state.ConnectionState;
import org.example.state.DeclinedState;
import org.example.state.RequestedState;

public class ConnectionService implements ConnectionObserver {
    private ConnectionPersistence connectionPersistence;
    private NotificationService notificationService;

    public ConnectionService(ConnectionPersistence connectionPersistence,
                             NotificationService notificationService) {
        this.connectionPersistence = connectionPersistence;
        this.notificationService = notificationService;
    }

    public void sendRequest(User fromUser, User toUser) {
        ConnectionState state = new RequestedState();
        Connection connection = new Connection(fromUser, toUser, state);
        connection.addObserver(this);
        notificationService.notifyConnectionRequest(toUser, fromUser);
        System.out.println("Connection request sent from " + fromUser.getName() +
                " to " + toUser.getName());
    }

    public void acceptRequest(User fromUser, User toUser) {
        ConnectionState state = new AcceptedState();
        Connection connection = new Connection(fromUser, toUser, state);
        connection.addObserver(this);
        connectionPersistence.saveConnection(connection);
        notificationService.notifyConnectionAccepted(fromUser, toUser);
        state.notifyUser(toUser);
    }

    public void declineRequest(User fromUser, User toUser) {
        ConnectionState state = new DeclinedState();
        Connection connection = new Connection(fromUser, toUser, state);
        connection.addObserver(this);
        notificationService.notifyConnectionDeclined(fromUser, toUser);
        state.notifyUser(toUser);
    }

    public void createConnection(User fromUser, User toUser) {
        acceptRequest(fromUser, toUser);
    }

    public boolean validateConnection(User from, User to) {
        return connectionPersistence.getConnections(from).contains(to);
    }

    @Override
    public void notifyUser(Connection connection) {
        connection.getState().notifyUser(connection.getTo());
    }
}
