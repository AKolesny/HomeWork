package org.example.airTravel.dto;

import java.time.LocalDate;

public class FlightsData {
    private final String departure_airport;
    private final String departure_date;
    private final String arrival_airport;
    private final String arrival_date;
    private final String offset;

    public FlightsData(String departure_airport, String departure_date,
                       String arrival_airport, String arrival_date,
                       String offset) {
        this.departure_airport = departure_airport;
        this.departure_date = departure_date;
        this.arrival_airport = arrival_airport;
        this.arrival_date = arrival_date;
        this.offset = offset;
    }

    public String getDeparture_airport() {
        return departure_airport;
    }

    public String getDeparture_date() {
        return departure_date;
    }

    public String getArrival_airport() {
        return arrival_airport;
    }

    public String getArrival_date() {
        return arrival_date;
    }

    public String getOffset() {
        return offset;
    }
}
