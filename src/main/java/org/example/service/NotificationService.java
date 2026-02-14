package org.example.service;

import org.example.entity.Notification;
import org.example.entity.User;
import org.example.enums.NotificationType;
import org.example.persistance.NotificationPersistence;

import java.util.List;
import java.util.UUID;

public class NotificationService {
    private NotificationPersistence notificationPersistence;

    public NotificationService(NotificationPersistence notificationPersistence) {
        this.notificationPersistence = notificationPersistence;
    }

    public void notifyConnectionRequest(User recipient, User sender) {
        String content = sender.getName() + " sent you a connection request";
        createNotification(recipient, NotificationType.CONNECTION_REQUEST, content);
    }

    public void notifyConnectionAccepted(User recipient, User acceptor) {
        String content = acceptor.getName() + " accepted your connection request";
        createNotification(recipient, NotificationType.CONNECTION_ACCEPTED, content);
    }

    public void notifyConnectionDeclined(User recipient, User decliner) {
        String content = decliner.getName() + " declined your connection request";
        createNotification(recipient, NotificationType.CONNECTION_DECLINED, content);
    }

    public void notifyNewMessage(User recipient, User sender) {
        String content = "New message from " + sender.getName();
        createNotification(recipient, NotificationType.NEW_MESSAGE, content);
    }

    public void notifyPostCreated(User recipient, User author) {
        String content = author.getName() + " created a new post";
        createNotification(recipient, NotificationType.POST_CREATED, content);
    }

    private void createNotification(User recipient, NotificationType type, String content) {
        String notificationId = UUID.randomUUID().toString();
        Notification notification = new Notification(notificationId, recipient, type, content);
        notificationPersistence.saveNotification(notification);
    }

    public List<Notification> getUserNotifications(User user) {
        return notificationPersistence.getUserNotifications(user);
    }

    public List<Notification> getUnreadNotifications(User user) {
        return notificationPersistence.getUnreadNotifications(user);
    }
}
