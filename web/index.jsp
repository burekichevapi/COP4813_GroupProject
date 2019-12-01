<%@page import="repository.ComplaintRepository"%>

<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->

<html>
    <head>
        <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
        <title>Complaints</title>        
    </head>
    <body>

        <div id="header"></div>
        <div class="container">
            <h1>Complaints about life...</h1>

            <form action="ComplaintController" method="GET">
                <input type="submit" name="complaintListButton" class="btn btn-primary" value="View Complaints">
            </form>

        </div>
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