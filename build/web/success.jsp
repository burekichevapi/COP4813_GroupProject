<%-- 
    Document   : success
    Created on : Sep 26, 2019, 9:03:53 PM
    Author     : Amer Delic
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>IT WORKED!!!</h1>
        Email = ${user.getEmail()}
        Password = ${user.getPassword()}
        <form action="AccountControllerFront" method="POST">
            <input type="submit" name="loginButton">
        </form>
    </body>
</html>
