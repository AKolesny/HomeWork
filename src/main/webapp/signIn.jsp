<%@ page language="java"
contentType="text/html;charset=UTF-8"
 pageEncoding="UTF-8"%>

 <html>
 <head>
     <title>Title</title>
 </head>
 <body>

 <h1>Авторизация</h1>
 <form action = <%=request.getContextPath() + "/api/login"%> method = "POST">
 Login:      <input type = "text" name = "login">
 <br /><br />
 Password:      <input type = "text" name = "password">
 <br /><br />

 <input type = "submit" value = "Войти" />
 </form>

 </body>
 </html>