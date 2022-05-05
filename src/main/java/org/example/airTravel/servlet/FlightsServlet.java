package org.example.airTravel.servlet;

import org.example.airTravel.dto.Airport;
import org.example.airTravel.dto.Flights;
import org.example.airTravel.dto.FlightsData;
import org.example.airTravel.service.AirportService;
import org.example.airTravel.service.FlightsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "FlightsServlet", urlPatterns = "/flights")
public class FlightsServlet extends HttpServlet {

    private final AirportService airportService;
    private final FlightsService flightsService;

    public FlightsServlet() {
        this.airportService = new AirportService();
        this.flightsService = new FlightsService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("airports", this.airportService.getAirports().stream()
                .sorted(Comparator.comparing(Airport::getAirport_name))
                .collect(Collectors.toList())
        );

        req.getRequestDispatcher("/airTravel/flights.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String departure_airport = req.getParameter("departure_airport");
        String departure_date = req.getParameter("departure_date");
        String arrival_airport = req.getParameter("arrival_airport");
        String arrival_date = req.getParameter("arrival_date");
        String offset = req.getParameter("offset");

        List<Flights> listFlights = flightsService.getListFlights(new FlightsData(departure_airport,
                departure_date, arrival_airport, arrival_date, offset));

        req.setAttribute("airports", this.airportService.getAirports().stream()
                .sorted(Comparator.comparing(Airport::getAirport_name))
                .collect(Collectors.toList())
        );
        req.setAttribute("flights", listFlights);
        req.setAttribute("offset", offset);

        req.getRequestDispatcher("/airTravel/flights.jsp").forward(req, resp);
    }
}
