<%@page import="repository.PostRepository"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Complaints</title>
        <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
        <%
            /*
            PostRepository postRep = new PostRepository();
            postRep.getPostsByThread(session.getAttribute("complaint").getComplaintId());
            request.setAttribute("posts", postRep);
            */
        %>
    </head>
    <body>
        <div id="header"></div>
        <div class="container">

            <h5 class="card-title">${complaint.getComplaintTitle()}</h5>
            <h6 class="card-subtitle mb-2 text-muted">created by: ${complaint.getAccount()}</h6>

            <form method="GET" action="PostController">
                <input type="submit" name="newPostButton" value="New Post" class="btn btn-primary"></strong><br><br>
            </form>

            <c:forEach var= "i" begin="1" end = "5">
                <div class="card">
                    <div class="card-body">
                        <p class="card-text">Post body example ${i}.</p>
                        <ul class="list-inline">
                            <li class="list-inline-item"><strong>user${i}</strong></li>
                            <li class="list-inline-item">posted: Nov. 14, 2019, 10:0${3*i} p.m.</li>
                        </ul>
                    </div>
                </div>
            </c:forEach>
        </div>
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