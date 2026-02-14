package org.example.entity;

import java.time.LocalDateTime;

public class Message {
    private String messageId;
    private String message;
    private LocalDateTime timestamp;
    private User from;
    private User to;

    public Message(String messageId, String message, LocalDateTime timestamp, User from, User to) {
        this.messageId = messageId;
        this.message = message;
        this.timestamp = timestamp;
        this.from = from;
        this.to = to;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
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

    @Override
    public String toString() {
        return "Message{" +
                "messageId='" + messageId + '\'' +
                ", message='" + message + '\'' +
                ", timestamp=" + timestamp +
                ", from=" + from.getName() +
                ", to=" + to.getName() +
                '}';
    }
}
