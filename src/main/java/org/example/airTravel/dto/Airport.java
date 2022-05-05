package org.example.airTravel.dto;

public class Airport {
    private final String airport_code;
    private final String airport_name;
    private final String city;
    private final String coordinates;
    private final String timezone;

    public Airport(String airport_code, String airport_name, String city, String coordinates, String timezone) {
        this.airport_code = airport_code;
        this.airport_name = airport_name;
        this.city = city;
        this.coordinates = coordinates;
        this.timezone = timezone;
    }

    public String getAirport_code() {
        return airport_code;
    }

    public String getAirport_name() {
        return airport_name;
    }

    public String getCity() {
        return city;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public String getTimezone() {
        return timezone;
    }
};
