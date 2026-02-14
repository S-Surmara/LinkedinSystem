package org.example.persistance;

import org.example.entity.Message;
import org.example.entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessagePersistence {
    private Map<User, List<Message>> userMessages;

    public MessagePersistence() {
        this.userMessages = new HashMap<>();
    }

    public void saveMessage(Message message) {
        userMessages.computeIfAbsent(message.getTo(), k -> new ArrayList<>()).add(message);
        userMessages.computeIfAbsent(message.getFrom(), k -> new ArrayList<>()).add(message);
    }

    public List<Message> getMessages(User user) {
        return userMessages.getOrDefault(user, new ArrayList<>());
    }
}
