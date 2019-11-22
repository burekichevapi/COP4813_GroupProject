<%-- 
    Document   : header
    Created on : Sep 17, 2019, 9:26:36 PM
    Author     : Amer Delic
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <div class="nav-scroller py-1 mb-2 navbar navbar-inverse">
        <ul class="nav d-flex">
            <a class="p-2 text-muted" href="index.jsp">Home</a>
            <a class="p-2 text-muted" href="post.jsp">Post</a>
            <a class="p-2 text-muted" href="about.jsp">About</a>
            <a class="p-2 text-muted" href="contact.jsp">Contact</a>
            <form class="form-inline mt-2 mt-md-0">
                <input class="form-control mr-sm-2" type="text" placeholder="Search Posts" aria-label="Search">
                <button class="btn btn-outline-primary" type="submit">Search</button>
            </form>
        </ul>
        <ul class="nav navbar-nav navbar-right d-flex">

            <c:if test = "${user.getUserName() == null}">
                <li><a class="p-2 text-muted" href="registration.jsp">Register</a>
                    <a class="p-2 text-muted" href="login.jsp">Log in</a></li>
                </c:if>
                <c:if test = "${user.getUserName() != null}">
                <li><form action="AccountControllerFront" method="POST">
                        <button type="submit" class="p-2 text-muted" name="editAccountButton">Welcome ${user.getUserName()}</button>
                    </form></li>
                <form action="AccountControllerFront" method="GET">
                    <button type="submit" class="p-2 text-muted" name="logOutButton">Log out</button>
                </form></li>
            </c:if>
        </ul>

    </div>
    <hr>
</head>
</html>
