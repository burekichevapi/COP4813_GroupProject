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
            <h1>Complaints List:</h1>

            <table class="table table-striped table-hover table-borderless">
                <thead>
                    <tr>
                        <th>Thread</th>
                        <th>User</th>
                        <th>Date</th>
                        <th>Read</th>
                    </tr>
                </thead>

                <c:forEach var="complaints" items="${complaintList}">
                    <tr>
                        <td>${complaints.getComplaintTitle()}</td>
                        <td>${complaints.getAccount()}</td>
                        <td>${complaints.getDate()}</td>
                    <form action="ComplaintController" method="GET">
                        <td><button type="submit" name="viewPost" value="${complaints.getComplaintId()}" class="btn btn-primary">Read Post</button></td>
                    </form>

                    </tr>
                </c:forEach>
            </table>

            <div style="z-index: 99;" id="footer"></div>

            <script src="//code.jquery.com/jquery-3.3.1.js"></script>
            <script>
                $(function () {
                    $("#header").load("header.jsp");
                    $("#footer").load("footer.jsp");
                });
            </script>
    </body>
</html>