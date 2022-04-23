<%@ page  language="java"
contentType="text/html;charset=UTF-8"
pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>Statistics</title>
</head>

<body>
<h1>Статистика</h1>
     <p>Количество зарегистрированных пользователей: ${countUsers}</p><br>
     <p>Kоличество активных пользователей: ${activeUser}</p><br>
     <p>Kоличество отправленных сообщений: ${countMessages}</p><br>
</body>
</html>