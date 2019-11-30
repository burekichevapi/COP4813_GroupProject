<!DOCTYPE html>

<html>
    <head>
        <title>Post New</title>        
    </head>
    <body>
        <div id="header"></div>
        <div class="container">            
            <form method="GET" action="PostController">
                <div class="form-group">
                    <label for="postBody">Response to: <strong>${complaint.getComplaintTitle()}</strong></label>
                    <textarea name="postBody" value="" class="form-control" id="postBody" rows="3"></textarea>
                </div>
                <div>
                    <input type="submit" class="btn btn-primary" name="postButton" value="Submit">
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