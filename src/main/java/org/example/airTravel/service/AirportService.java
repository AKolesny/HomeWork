package org.example.airTravel.service;

import org.example.airTravel.dao.AirportsDao;
import org.example.airTravel.dto.Airport;

import java.util.List;

public class AirportService {
    private final AirportsDao airportsDao;

    public AirportService() {
        this.airportsDao = new AirportsDao();
    }

    public List<Airport> getAirports() {
        return this.airportsDao.getAllAirports();
    }
}
