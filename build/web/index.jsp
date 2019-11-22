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
        <table class="table table-striped table-hover table-borderless">
            <!--Table head-->
            <thead>
                <tr>
                    <th>Post</th>
                    <th>User</th>
                    <th>Date</th>
                </tr>
            </thead>
            <!--Table head-->

            <!--Table body-->
            <tbody>
                <tr>
                    <th>Title of Post</th>
                    <th>Amer</th>
                    <th>9/18/2019</th>
                </tr>
                <tr>
                    <th>NetBeans SUCKS!</th>
                    <th>Steven</th>
                    <th>9/18/2019</th>
                </tr>
                <tr>
                    <th>Another Title</th>
                    <th>Another User</th>
                    <th>9/18/2019</th>
                </tr>
            </tbody>
            <!--Table body-->
        </table>
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