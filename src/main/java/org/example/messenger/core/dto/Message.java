package org.example.messenger.core.dto;

import java.time.LocalDateTime;

public class Message {

    private final LocalDateTime departureTime;
    private final String fromUser;
    private final String toUser;
    private final String text;

    public Message(LocalDateTime departureTime, String fromUser, String toUser, String text) {
        this.departureTime = departureTime;
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.text = text;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public String getFromUser() {
        return fromUser;
    }

    public String getToUser() {
        return toUser;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "<p>" + departureTime.getYear() +  "-" + departureTime.getMonthValue() + "-" + departureTime.getDayOfMonth()
                 + " " + departureTime.getHour() + ":" + departureTime.getMinute() + ":" + departureTime.getSecond() + " от кого: " + fromUser + "</p>" +
                "<p> Сообщение:  " + text + "</p>";
    }
}
