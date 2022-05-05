<%@ page  language="java"
contentType="text/html;charset=UTF-8"
pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>
        <title>Airports</title>
    </head>

    <body>
        <table>
            <thead>
                <tr>
                    <th>airport_code</th>
                    <th>airport_name</th>
                    <th>city</th>
                    <th>coordinates</th>
                    <th>timezone</th>
                </tr>
            </thead>

            <tbody>
                <c:forEach var="airport" items="${listAirports}">
                    <tr>
                        <td>${airport.airport_code}</td>
                        <td>${airport.airport_name}</td>
                        <td>${airport.city}</td>
                        <td>${airport.coordinates}</td>
                        <td>${airport.timezone}</td>
                    </tr
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>