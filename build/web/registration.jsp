<%-- 
    Document   : registration
    Created on : Sep 21, 2019, 8:03:24 PM
    Author     : Amer Delic
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Register</title>
        <link href="css/loginPage.css" rel="stylesheet">
    </head>
    <body class="text-center">
        <div id="header"></div>
        <form action="AccountControllerFront" method="POST"
              class="form-signin" >
            <h1 class="h3 mb-3 font-weight-normal">Register</h1>
            <input type="text" class="form-control" placeholder="User Name"
                   name="userName" autofocus>
            <div type="text"style="color:red">${errors.getErrors().userName}</div>
            <br>
            <input type="email" class="form-control" placeholder="Email address"
                   name="email">
            <br>
            <input type="password" class="form-control" placeholder="Password" 
                   name="password">
            <div type="text" style="color:red">${errors.getErrors().password}</div>
            <br>
            <div type="text" style="color:red">${errors.getErrors().invalidRegistration}</div>
            <button class="btn btn-lg btn-primary btn-block" type="submit" 
                    name="registerationButton">Register</button>
        </form>
        <div id="footer"></div>
        <script src="//code.jquery.com/jquery-3.3.1.js"></script>
        <script>
            $(function () {
                $("#header").load("header.jsp");
                $("#footer").load("footer.jsp");
            });
        </script>
    </body>
</html>
