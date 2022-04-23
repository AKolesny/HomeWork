package org.example.messenger.service;

import org.example.messenger.core.dto.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class SaveUser {

    private static final String USER = "user";

    private final DateTimeFormatter formatter;

    private final StorageUsers storageUsers;
    private final Statistic statistic;


    public SaveUser() {
        this.formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        this.storageUsers = StorageUsers.getInstance();
        this.statistic = Statistic.getInstance();
    }

    public void save(String login, String password, String lastName,
                     String firstName, String middleName, String birthday) {
        checkParams(login, "login");
        checkParams(password, "password");
        checkParams(lastName, "lastName");
        checkParams(firstName, "firstName");
        checkParams(middleName, "middleName");

        LocalDate date = checkBirthday(birthday);

        storageUsers.addUser(new User(login, password, lastName,
                firstName, middleName, date, LocalDateTime.now(), USER));

        statistic.addUser();
    }

    private void checkParams(String params, String name) {
        if (params == null) {
            throw new IllegalArgumentException("Не введен " + name);
        }
    }

    private LocalDate checkBirthday (String birthday) {
        if (birthday != null) {
            try {
                return LocalDate.parse(birthday, this.formatter);
            } catch (DateTimeParseException e) {
                throw new IllegalArgumentException("Не верный формат birthday");
            }
        }
        throw new IllegalArgumentException("Не введен birthday");
    }
}
