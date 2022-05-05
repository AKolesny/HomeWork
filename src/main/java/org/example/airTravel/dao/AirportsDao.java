package org.example.airTravel.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.example.airTravel.dto.Airport;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AirportsDao {
    private final DataSource dataSource;

    public AirportsDao() {
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

    public List<Airport> getAllAirports() {
        List<Airport> airports = new ArrayList<>();

        try (Connection connection = this.dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "SELECT\n" +
                             "    airport_code,\n" +
                             "    airport_name,\n" +
                             "    city,\n" +
                             "    coordinates,\n" +
                             "    timezone\n" +
                             "FROM\n" +
                             "    bookings.airports\n" +
                             "ORDER BY\n" +
                             "    city ASC;"
             )
        ) {
            while (resultSet.next()) {
                airports.add(map(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return airports;
    }

    private Airport map(ResultSet rs) throws SQLException {

        return new Airport(rs.getString("airport_code"),
                rs.getString("airport_name"),
                rs.getString("city"),
                rs.getString("coordinates"),
                rs.getString("timezone"));
    }
}
