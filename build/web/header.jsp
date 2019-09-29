<%-- 
    Document   : header
    Created on : Sep 17, 2019, 9:26:36 PM
    Author     : Amer Delic
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <div class="nav-scroller py-1 mb-2">
        <div></div>
        <nav class="nav d-flex">
            <a class="p-2 text-muted" href="index.jsp">Home</a>
            <a class="p-2 text-muted" href="about.jsp">About</a>
            <a class="p-2 text-muted" href="contact.jsp">Contact</a>
            
            <form action="Controllers/Account/AccountControllerFront" method="POST">
            <input class="p-2 text-muted" name="registerationButton" type="submit" value="Register" style="background:none; border-width:0px; color:blue;" />
            </form>
            
            <a class="p-2 text-muted" href="#">Something</a>
            
            <form action="Controllers/Account/AccountControllerFront" method="POST">
            <input class="p-2 text-muted" name="signInButton" type="submit" value="Login" style="background:none; border-width:0px; color:blue;" />
            </form>
            
            <form class="form-inline mt-2 mt-md-0">
                <input class="form-control mr-sm-2" type="text" placeholder="Search Posts" aria-label="Search">
                <button class="btn btn-outline-primary" type="submit">Search</button>
            </form>
        </nav>
    </div>
    <hr>
</head>
</html>
