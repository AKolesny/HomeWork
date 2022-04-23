package org.example.messenger.service;

import org.example.messenger.core.dto.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class StorageUsers {
    private static final StorageUsers INSTANCE = new StorageUsers();
    private static final String ADMIN = "admin";

    private final Map<String, User> users;

    private StorageUsers() {
        users = new HashMap<>();

        users.put(ADMIN, new User("admin", "admin", "Колесный", "Александр", "Николаевич",
                LocalDate.of(1993, 7, 11), LocalDateTime.now(), ADMIN));
    }

    public void addUser(User user) {
        if (this.users.containsKey(user.getLogin())){
            throw new IllegalArgumentException("Такоей login занят!");
        } else {
            users.put(user.getLogin(), user);
        }
    }

    public void AuthorizationUser (String login, String password) {
        if (login != null && password != null) {
            if (this.users.containsKey(login)) {
                if (!this.users.get(login).getPassword().equals(password)) {
                    throw new IllegalArgumentException("Неверный password!");
                }
            } else {
                throw new IllegalArgumentException("Неверный login!");
            }
        } else {
            throw new IllegalArgumentException("Не ввели login или password!");
        }
    }

    public User getUser (String login) {
       return this.users.get(login);
    }

    public boolean isUser (String user) {
       return this.users.containsKey(user);
    }


    public static StorageUsers getInstance() {
        return INSTANCE;
    }

}
