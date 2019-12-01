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

            <%
                /*
                ComplaintRepository comp = new ComplaintRepository();
                comp.getComplaints();
                request.setAttribute("complaintData", comp);
                 */
            %>

            <table class="table table-striped table-hover table-borderless">
                <thead>
                    <tr>
                        <th>Thread</th>
                        <th>User</th>
                        <th>Date</th>
                    </tr>
                </thead>

                <c:forEach var="complaint" items="${complaintData}">
                    <tr>
                        <td>${complaint.getComplaintTitle()}</td>
                        <td>${complaint.getAccount()}</td>
                        <td>${complaint.getDate()}</td>
                    </tr>
                </c:forEach>


                <table class="table table-striped table-hover table-borderless">
                    <thead>
                        <tr>
                            <th>Thread</th>
                            <th>User</th>
                            <th>Date</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td><a href='#'>Complaint1</a></td>
                            <td>Amer</td>
                            <td>Sep. 09, 2019, 09:10 a.m.</td>
                        </tr>
                        <tr>
                            <td><a href='#'>NetBeans rant!</a></td>
                            <td>Steven</td>
                            <td>Nov. 10, 2019, 11:03 p.m.</td>
                        </tr>
                        <tr>
                            <td><a href="#">Sample Thread 1</a></td>
                            <td>cgeorgiades</td>
                            <td>Nov. 14, 2019, 10:0${3*i} p.m.</td>
                        </tr>
                    </tbody>
                </table>
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