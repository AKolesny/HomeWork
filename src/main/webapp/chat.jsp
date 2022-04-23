<%@ page contentType="text/html;charset=UTF-8"
         language="java"
          pageEncoding="UTF-8" %>
<html>
<head>
    <title>chat</title>
</head>
<body>
<form action = <%=request.getContextPath() + "/api/message"%> method = "GET">
<input type = "submit" value = "Получить" />
</form>
</body>
</html>