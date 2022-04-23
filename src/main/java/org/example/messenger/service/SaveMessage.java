package org.example.messenger.service;

import org.example.messenger.core.dto.Message;

import java.time.LocalDateTime;

public class SaveMessage {
    private final StorageUsers storageUsers;
    private final StorageMessages storageMessages;
    private final Statistic statistic;

    public SaveMessage() {
        this.storageUsers = StorageUsers.getInstance();
        this.storageMessages = StorageMessages.getInstance();
        this.statistic = Statistic.getInstance();
    }

    public void save(String fromUser, String toUser, String text) {
        checkToUser(toUser);
        checkText(text);

        storageMessages.addMessage(toUser, new Message(LocalDateTime.now(),
                fromUser, toUser, text));

        statistic.addMessage();
    }

    private void checkToUser(String toUser) {
        if (toUser != null) {
            if (!storageUsers.isUser(toUser)) {
                throw new IllegalArgumentException("Такой user не существует!");
            }
        } else {
            throw new IllegalArgumentException("Не указан user!");
        }
    }

    private void checkText (String text) {
        if (text == null || text.length() == 0) {
            throw new IllegalArgumentException("Отсуствует text!");
        }
    }
}
