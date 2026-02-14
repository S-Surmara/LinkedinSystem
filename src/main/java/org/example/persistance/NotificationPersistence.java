package org.example.persistance;

import org.example.entity.Notification;
import org.example.entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotificationPersistence {
    private Map<User, List<Notification>> userNotifications;

    public NotificationPersistence() {
        this.userNotifications = new HashMap<>();
    }

    public void saveNotification(Notification notification) {
        userNotifications.computeIfAbsent(notification.getRecipient(), k -> new ArrayList<>())
                .add(notification);
    }

    public List<Notification> getUserNotifications(User user) {
        return userNotifications.getOrDefault(user, new ArrayList<>());
    }

    public List<Notification> getUnreadNotifications(User user) {
        List<Notification> notifications = getUserNotifications(user);
        List<Notification> unread = new ArrayList<>();
        for (Notification notif : notifications) {
            if (!notif.isRead()) {
                unread.add(notif);
            }
        }
        return unread;
    }
}
