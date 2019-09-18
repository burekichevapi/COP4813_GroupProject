<%-- 
    Document   : login
    Created on : Sep 18, 2019, 4:21:43 PM
    Author     : amerd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>        
        <script src="//code.jquery.com/jquery-3.3.1.js"></script>
        <script>
            $(function () {
                $("#header").load("header.jsp");
                $("#footer").load("footer.jsp");
            });
        </script>
        <link href="css/loginPage.css" rel="stylesheet">
    </head>
    <body class="text-center">
        <div id="header"></div>
        <form class="form-signin">
            <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
            <label class="sr-only">Email address</label>
            <input type="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
            <label class="sr-only">Password</label>
            <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
            <div class="checkbox mb-3">
                <label>
                    <input type="checkbox" value="rememberMe"> Remember me
                </label>
            </div>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        </form>
        <div id="footer"></div>
    </body>
</html>
