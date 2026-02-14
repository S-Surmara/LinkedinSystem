package org.example.entity;

import org.example.enums.NotificationType;

import java.time.LocalDateTime;

public class Notification {
    private String notificationId;
    private User recipient;
    private NotificationType type;
    private String content;
    private boolean isRead;
    private LocalDateTime timestamp;

    public Notification(String notificationId, User recipient, NotificationType type, String content) {
        this.notificationId = notificationId;
        this.recipient = recipient;
        this.type = type;
        this.content = content;
        this.isRead = false;
        this.timestamp = LocalDateTime.now();
    }

    public String getNotificationId() {
        return notificationId;
    }

    public User getRecipient() {
        return recipient;
    }

    public NotificationType getType() {
        return type;
    }

    public String getContent() {
        return content;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "notificationId='" + notificationId + '\'' +
                ", recipient=" + recipient.getName() +
                ", type=" + type +
                ", content='" + content + '\'' +
                ", isRead=" + isRead +
                ", timestamp=" + timestamp +
                '}';
    }
}
