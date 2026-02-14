package org.example.entity;

import org.example.observer.ConnectionObserver;
import org.example.state.ConnectionState;

import java.util.ArrayList;
import java.util.List;

public class Connection {
    private User from;
    private User to;
    private ConnectionState state;
    private List<ConnectionObserver> observers;

    public Connection(User from, User to, ConnectionState state) {
        this.from = from;
        this.to = to;
        this.state = state;
        this.observers = new ArrayList<>();
    }

    public User getFrom() {
        return from;
    }

    public void setFrom(User from) {
        this.from = from;
    }

    public User getTo() {
        return to;
    }

    public void setTo(User to) {
        this.to = to;
    }

    public ConnectionState getState() {
        return state;
    }

    public void setState(ConnectionState state) {
        this.state = state;
        notifyObservers();
    }

    public void addObserver(ConnectionObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(ConnectionObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (ConnectionObserver observer : observers) {
            observer.notifyUser(this);
        }
    }

    @Override
    public String toString() {
        return "Connection{" +
                "from=" + from.getName() +
                ", to=" + to.getName() +
                ", state=" + state.getClass().getSimpleName() +
                '}';
    }
}
