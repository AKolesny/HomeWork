package org.example.messenger.core.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class User {
    private final String login;
    private String password;
    private String lastName;
    private String firstName;
    private String middleName;
    private final LocalDate birthday;
    private final LocalDateTime registrationDate;
    private final String role;

    public User(String login, String password, String lastName, String firstName, String middleName,
                LocalDate birthday, LocalDateTime registrationDate, String role) {
        this.login = login;
        this.password = password;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.birthday = birthday;
        this.registrationDate = registrationDate;
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public String getRole() {
        return role;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
}
