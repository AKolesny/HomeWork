package org.example.airTravel.service;

import org.example.airTravel.dao.FlightsDao;
import org.example.airTravel.dto.Flights;
import org.example.airTravel.dto.FlightsData;

import java.util.List;

public class FlightsService {

    private List<Flights> flights;
    private final FlightsDao flightsDao;
    private String where;

    public FlightsService() {
        this.flightsDao = new FlightsDao();
    }

    public List<Flights> getListFlights(FlightsData flightsData) {
        if (isNewRequest(flightsData)) {
            newWHERE(flightsData);
            return this.flightsDao.getListFlights(where);
        } else {
            String offset = newOffset(flightsData.getOffset());
            return this.flightsDao.getListFlights(offset);
        }
    }

    private boolean isNewRequest(FlightsData flightsData) {
        if (flightsData.getDeparture_airport() == null ||
                flightsData.getDeparture_date() == null ||
                flightsData.getArrival_airport() == null ||
                flightsData.getArrival_date() == null ||
                flightsData.getOffset() != null) {
            return false;
        } else return flightsData.getDeparture_airport().equals("") ||
                flightsData.getDeparture_date().equals("") ||
                flightsData.getArrival_airport().equals("") ||
                flightsData.getArrival_date().equals("") ||
                flightsData.getOffset() == null;
    }

    private void newWHERE(FlightsData flightsData) {
        this.where = " WHERE ";
        boolean and = false;

        if (flightsData.getDeparture_airport().equals("") &&
                flightsData.getDeparture_date().equals("") &&
                flightsData.getArrival_airport().equals("") &&
                flightsData.getArrival_date().equals("")) {
            this.where = "";
        }

        if (!flightsData.getDeparture_airport().equals("")) {
            this.where = this.where + "departure_airport_name = '" + flightsData.getDeparture_airport() + "'";
            and = true;
        }

        if (!flightsData.getDeparture_date().equals("")) {
            if (and) {
                this.where = this.where + " AND ";
            }
            this.where = this.where + "CAST(scheduled_departure_local AS VARCHAR) LIKE '" + flightsData.getDeparture_date() + "%'";
            and = true;
        }

        if (!flightsData.getArrival_airport().equals("")) {
            if (and) {
                this.where = this.where + " AND ";
            }
            this.where = this.where + "arrival_airport_name = '" + flightsData.getArrival_airport() + "'";
            and = true;
        }

        if (!flightsData.getArrival_date().equals("")) {
            if (and) {
                this.where = this.where + " AND ";
            }
            this.where = this.where + "CAST(scheduled_arrival_local AS VARCHAR) LIKE '" + flightsData.getArrival_date() + "%'";
        }
        this.where = this.where + " LIMIT 25";
    }

    private String newOffset(String offset) {
        return where + " OFFSET(25 * " + offset + ")";
    }
}
