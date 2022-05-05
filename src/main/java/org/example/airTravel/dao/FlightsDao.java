package org.example.airTravel.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.example.airTravel.dto.Flights;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FlightsDao {
    private final DataSource dataSource;

    public FlightsDao() {
        ComboPooledDataSource pool = new ComboPooledDataSource();

        try {
            pool.setDriverClass("org.postgresql.Driver");
        } catch (PropertyVetoException e) {
            throw  new RuntimeException("Проверь имя драйвера!!!!", e);
        }

        pool.setJdbcUrl("jdbc:postgresql://localhost:5432/demo");
        pool.setUser("postgres");
        pool.setPassword("postgres");

        this.dataSource = pool;
    }

    public List<Flights> getListFlights(String where) {
        List<Flights> flights = new ArrayList<>();

        try (Connection connection = this.dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "SELECT\n" +
                             "    flight_id,\n" +
                             "    flight_no,\n" +
                             "    scheduled_departure,\n" +
                             "    scheduled_departure_local,\n" +
                             "    scheduled_arrival,\n" +
                             "    scheduled_arrival_local,\n" +
                             "    scheduled_duration,\n" +
                             "    departure_airport,\n" +
                             "    departure_airport_name,\n" +
                             "    departure_city,\n" +
                             "    arrival_airport,\n" +
                             "    arrival_airport_name,\n" +
                             "    arrival_city,\n" +
                             "    status,\n" +
                             "    aircraft_code,\n" +
                             "    actual_departure,\n" +
                             "    actual_departure_local,\n" +
                             "    actual_arrival,\n" +
                             "    actual_arrival_local,\n" +
                             "    actual_duration\n" +
                             "FROM\n" +
                             "    bookings.flights_v" + where + ";"
             )
        ) {
            while (resultSet.next()) {
                flights.add(map(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return flights;
    }

    private Flights map(ResultSet rs) throws SQLException {

        return new Flights(isNull(rs.getString("flight_id")),
                isNull(rs.getString("flight_no")),
                isNull(rs.getString("scheduled_departure")),
                isNull(rs.getString("scheduled_departure_local")),
                isNull(rs.getString("scheduled_arrival")),
                isNull(rs.getString("scheduled_arrival_local")),
                isNull(rs.getString("scheduled_duration")),
                isNull(rs.getString("departure_airport")),
                isNull(rs.getString("departure_airport_name")),
                isNull(rs.getString("departure_city")),
                isNull(rs.getString("arrival_airport")),
                isNull(rs.getString("arrival_airport_name")),
                isNull(rs.getString("arrival_city")),
                isNull(rs.getString("status")),
                isNull(rs.getString("aircraft_code")),
                isNull(rs.getString("actual_departure")),
                isNull(rs.getString("actual_departure_local")),
                isNull(rs.getString("actual_arrival")),
                isNull(rs.getString("actual_arrival_local")),
                isNull(rs.getString("actual_duration")));
    }

    private String isNull(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }
}
