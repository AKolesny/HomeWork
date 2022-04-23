<%@ page language="java"
contentType="text/html;charset=UTF-8"
 pageEncoding="UTF-8"%>

 <html>
  <head>
      <title>Registration</title>
  </head>

  <body>

<h1>Регистрация) </h1>
      <form action = <%=request.getContextPath() + "/api/user"%> method = "POST">
         Login:      <input type = "text" name = "login">
         <br /><br />
         Password:      <input type = "text" name = "password">
         <br /><br />
         LastName:       <input type = "text" name = "lastName">
         <br /><br />
         FirstName:       <input type = "text" name = "firstName">
         <br /><br />
         MiddleName:       <input type = "text" name = "middleName">
         <br /><br />
         Birthday:     <input type = "text" name = "birthday"/>
         <br /><br />
         <input type = "submit" value = "Создать." />
      </form>

 </body>
</html>