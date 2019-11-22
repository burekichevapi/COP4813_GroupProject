<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Complaints</title>        
    </head>
    <body>
        <div id="header"></div>
        <div class="container">            
        <form>
            <div class="form-group">
                <label for="complaintTitle"><strong>Complaint Title</strong></label>
                <input type="text" class="form-control" id="complaintTitle" placeholder="Name your complaint...">
            </div>
            <div class="form-group">
                <label for="complaintBody"><strong>Complaint Body</strong></label>
                <textarea class="form-control" id="complaintBody" rows="3"></textarea>
            </div>
            <div>
                <input type="button" class="btn btn-primary" name="postButton" value="Submit">
            </div>
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