<%-- 
    Document   : login
    Created on : Sep 18, 2019, 4:21:43 PM
    Author     : amerd
--%>

<%--    
        Admin Email: Admin@test.com
        Admin Password: Password123!
        Admin Username: Admin123

        Admin Email: Test@test.com
        Admin Password: Password123$
        Admin Username: Test123
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <link href="css/loginPage.css" rel="stylesheet">
    </head>
    <body class="text-center">
        <div id="header"></div>
        <form action="AccountControllerFront" method="POST"
              class="form-signin" >
            <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
            <label class="sr-only">Email address</label>
            <input type="email" name="email" value="${userEmailCookie.getValue()}" class="form-control" placeholder="Email address" autofocus>
            <label class="sr-only">Password</label>
            <input type="password" id="inputPassword" name="password" value="${userPasswordCookie.getValue()}"  class="form-control" placeholder="Password">
            <div type="text"style="color:red">${errors.getErrors().invalidCredentials}</div>
            <div class="checkbox mb-3">
                <label>
                    <input type="checkbox" value="rememberMe"> Remember me
                </label>
            </div>
            <button class="btn btn-lg btn-primary btn-block" type="submit" name="loginButton">Login</button>
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
