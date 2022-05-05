<%@ page  language="java"
contentType="text/html;charset=UTF-8"
pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>
        <title>Flights</title>
    </head>

    <body>

        <form action=<%= request.getContextPath() + "/flights"%> method="POST">

                <table>
                    <thead>
                        <tr>
                            <th>departure_airport</th>
                            <th>departure_date</th>
                            <th>arrival_airport</th>
                            <th>arrival_date</th>
                        </tr>
                    </thead>

                    <tbody>
                            <tr>
                                <td>
                                    <select name="departure_airport">
                                        <option value="">Выберите город</option>
                                        <c:forEach var = "airport" items = "${airports}">
                                            <option value = "${airport.airport_name}"> ${airport.airport_name} </option>
                                        </c:forEach>
                                    </select>
                                </td>
                                <td><input name = "departure_date" type = "date"/></td>
                                <td>
                                    <select name = "arrival_airport">
                                        <option value = "">Выберите город</option>
                                        <c:forEach var = "airport" items = "${airports}">
                                            <option value = "${airport.airport_name}"> ${airport.airport_name} </option>
                                        </c:forEach>
                                    </select>
                                </td>
                                <td><input name = "arrival_date" type = "date"/></td>
                            </tr>
                    </tbody>
                </table>
            <input type = "submit" value = "Получить" />
        </form>

        <c:if test="${flights != null && flights.size() != 0}">
            <table>
                <thead>
                    <tr>
                        <th>flight_id</th>
                        <th>flight_no</th>
                        <th>scheduled_departure</th>
                        <th>scheduled_departure_local</th>
                        <th>scheduled_arrival</th>
                        <th>scheduled_arrival_local</th>
                        <th>scheduled_duration</th>
                        <th>departure_airport</th>
                        <th>departure_airport_name</th>
                        <th>departure_city</th>
                        <th>arrival_airport</th>
                        <th>arrival_airport_name</th>
                        <th>arrival_city</th>
                        <th>status</th>
                        <th>aircraft_code</th>
                        <th>actual_departure</th>
                        <th>actual_departure_local</th>
                        <th>actual_arrival</th>
                        <th>actual_arrival_local</th>
                        <th>actual_duration</th>
                    </tr>
                </thead>

                <tbody>
                    <c:forEach var="flight" items="${flights}">
                        <tr>
                            <td>${flight.flight_id}</td>
                            <td>${flight.flight_no}</td>
                            <td>${flight.scheduled_departure}</td>
                            <td>${flight.scheduled_departure_local}</td>
                            <td>${flight.scheduled_arrival}</td>
                            <td>${flight.scheduled_arrival_local}</td>
                            <td>${flight.scheduled_duration}</td>
                            <td>${flight.departure_airport}</td>
                            <td>${flight.departure_airport_name}</td>
                            <td>${flight.departure_city}</td>
                            <td>${flight.arrival_airport}</td>
                            <td>${flight.arrival_airport_name}</td>
                            <td>${flight.arrival_city}</td>
                            <td>${flight.status}</td>
                            <td>${flight.aircraft_code}</td>
                            <td>${flight.actual_departure}</td>
                            <td>${flight.actual_departure_local}</td>
                            <td>${flight.actual_arrival}</td>
                            <td>${flight.actual_arrival_local}</td>
                            <td>${flight.actual_duration}</td>
                        </tr
                    </c:forEach>
                </tbody>
            </table>
            <c:if test="${offset != null && Integer.parseInt(offset) != 0}">
                <form action=<%= request.getContextPath() + "/flights?offset=" +
                (Integer.parseInt(request.getParameter("offset")) - 1)%> method="POST">
                    <input type = "submit" value = "Назад" />
                </form>
            </c:if>
            <c:if test="${flights != null && flights.size() == 25}">
                <form action=<%= request.getContextPath() + "/flights?offset=" +
                (request.getParameter("offset") == null ? "1" : Integer.parseInt(request.getParameter("offset")) + 1)%> method="POST">
                    <input type = "submit" value = "Далее" />
                </form>
            </c:if>
        </c:if>
    </body>
</html>