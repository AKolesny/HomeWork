package org.example.messenger.service;

import org.example.messenger.core.dto.Message;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StorageMessages {
    private static final StorageMessages INSTANCE = new StorageMessages();

    private final Map<String, ArrayList<Message>> messages;

    private StorageMessages() {
        this.messages = new HashMap<>();
    }

    public void addMessage(String toUser, Message message) {
        if (!messages.containsKey(toUser)) {
            messages.put(toUser, new ArrayList<>());
        }

        messages.get(toUser).add(message);
    }

    public ArrayList<Message> getMessages(String user) {
        if (this.messages.containsKey(user)) {
            return this.messages.get(user);
        }
        return null;
    }

    public static StorageMessages getInstance() {
        return INSTANCE;
    }
}
