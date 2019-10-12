<%-- 
    Document   : About
    Created on : Sep 19, 2019, 4:04:42 PM
    Author     : Amer Delic
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="//code.jquery.com/jquery-3.3.1.js"></script>
        <script>
            $(function () {
                $("#header").load("header.jsp");
                $("#footer").load("footer.jsp");
            });
        </script>
        <link href="css/aboutPage.css" rel="stylesheet">
    </head>
    <body>
        <div id="header"></div>
        <h1 class="text-center">The Team</h1>
        <div class="container">
            <div class="row text-center">

                <div class="col-xl-3 col-sm-6 mb-5">
                    <div class="bg-white rounded shadow-sm py-5 px-4"><img src="css/pictures/amer.jpg" alt="" width="100" class="img-fluid rounded-circle mb-3 img-thumbnail shadow-sm">
                        <h5 class="mb-0">Amer Delic</h5><span class="small text-uppercase text-muted">Team Member</span>
                        <ul class="social mb-0 list-inline mt-3">
                            <li class="list-inline-item"><a href="https://github.com/burekichevapi" class="social-link"><img src="css/pictures/GitHub-Mark-32px.png"></i></a></li>
                            <li class="list-inline-item"><a href="https://www.linkedin.com/in/amer-delic-78647714a" class="social-link"><img src="css/pictures/linkedin-logo.png"></i></a></li>
                        </ul>
                    </div>
                </div>

                <div class="col-xl-3 col-sm-6 mb-5">
                    <div class="bg-white rounded shadow-sm py-5 px-4"><img src="#pic" alt="" width="100" class="img-fluid rounded-circle mb-3 img-thumbnail shadow-sm">
                        <h5 class="mb-0">Chris</h5><span class="small text-uppercase text-muted">Team Member</span>
                        <ul class="social mb-0 list-inline mt-3">
                            <li class="list-inline-item"><a href="https://github.com/burekichevapi" class="social-link"><img src="css/pictures/GitHub-Mark-32px.png"></i></a></li>
                            <li class="list-inline-item"><a href="https://www.linkedin.com/in/amer-delic-78647714a" class="social-link"><img src="css/pictures/linkedin-logo.png"></i></a></li>
                        </ul>
                    </div>
                </div>

            </div>
        </div>
        <div id="footer"></div>
    </body>
</html>
