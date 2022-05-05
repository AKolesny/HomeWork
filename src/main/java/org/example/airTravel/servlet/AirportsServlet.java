package org.example.airTravel.servlet;

import org.example.airTravel.service.AirportService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AirportsServlet", urlPatterns = "/airports")
public class AirportsServlet extends HttpServlet {

    private final AirportService airportService;

    public AirportsServlet() {
        this.airportService = new AirportService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listAirports", airportService.getAirports());

        req.getRequestDispatcher("/airTravel/airports.jsp").forward(req, resp);
    }
}
