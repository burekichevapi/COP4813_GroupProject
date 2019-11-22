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
    </head>
    <body>
        <div id="header"></div>
        <div class="container">

            <h5 class="card-title">Thread Title</h5>
            <h6 class="card-subtitle mb-2 text-muted">created by: username</h6>
            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>

            <c:forEach var= "i" begin="1" end = "5">
                <div class="card" style="margin-left:<c:out value="${i * 20}"/>px;">
                    <div class="card-body">
                        <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                        <ul class="list-inline">
                            <li class="list-inline-item"><strong>username</strong></li>
                            <li class="list-inline-item">post date</li>
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