package org.example.service;

import org.example.entity.Message;
import org.example.entity.User;
import org.example.persistance.MessagePersistence;

import java.time.LocalDateTime;
import java.util.UUID;

public class MessagingService {
    private ConnectionService connectionService;
    private MessagePersistence messagePersistence;
    private NotificationService notificationService;

    public MessagingService(ConnectionService connectionService,
                            MessagePersistence messagePersistence,
                            NotificationService notificationService) {
        this.connectionService = connectionService;
        this.messagePersistence = messagePersistence;
        this.notificationService = notificationService;
    }

    public Message createMessage(String message, LocalDateTime timestamp, User from, User to) {
        if (!connectionService.validateConnection(from, to)) {
            throw new IllegalStateException("Users are not connected");
        }
        String messageId = UUID.randomUUID().toString();
        Message msg = new Message(messageId, message, timestamp, from, to);
        messagePersistence.saveMessage(msg);
        notificationService.notifyNewMessage(to, from);
        return msg;
    }

    public void sendMessage(User from, User to, String message, LocalDateTime timestamp) {
        createMessage(message, timestamp, from, to);
    }
}
