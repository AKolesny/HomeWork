<%@ page contentType="text/html;charset=UTF-8"
         language="java"
          pageEncoding="UTF-8" %>
<html>
<head>
    <title>message</title>
</head>
<body>
<form action = <%=request.getContextPath() + "/api/message"%> method = "POST">
User:      <input type = "text" name = "user">
 <br /><br />
 Text:      <input type = "text" name = "text">
 <br /><br />
<input type = "submit" value = "Отправить" />
</form>

</body>
</html>