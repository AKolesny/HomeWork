package org.example.messenger.service;

public class Statistic {

    private static final Statistic INSTANCE = new Statistic();

    private int countUsers;
    private int countMessages;
    private int countActiveUser;

    private Statistic() {
    }

    public void addUser() {
        this.countUsers++;
    }

    public void addMessage() {
        this.countMessages++;
    }

    public void addActiveUser() {
        this.countActiveUser++;
    }

    public void depActiveUser() {
        this.countActiveUser--;
    }

    public int getCountUsers() {
        return countUsers;
    }

    public int getCountMessages() {
        return countMessages;
    }

    public static Statistic getInstance() {
        return INSTANCE;
    }

    public int getCountActiveUser() {
        return countActiveUser;
    }
}
