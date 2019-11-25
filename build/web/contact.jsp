<%-- 
    Document   : Contact
    Created on : Sep 19, 2019, 4:05:12 PM
    Author     : Amer Delic
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Contact Page</title>        
    </head>
    <body>
        <div id="header"></div>
        <div class="container">            
            <h1>Contact Page</h1>
            <div class="container-fluid">
                <h4>Amer Delic</h4>
                <ul>
                    <li>Email: <a href="mailto:ad18cx@my.fsu.edu">ad18cx@my.fsu.edu</a></li>
                    <li>Phone: 727.555.5555</li>
                </ul>
                <h4>Chris Georgiades</h4>
                <ul>
                    <li>Email: <a href="mailto:cg16n@my.fsu.edu">cg16n@my.fsu.edu</a></li>
                    <li>Phone: 727.555.5555</li>
                </ul>   
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