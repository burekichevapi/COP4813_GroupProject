<!DOCTYPE html>

<html>
    <head>
        <title>Post New</title>        
    </head>
    <body>
        <div id="header"></div>
        <div class="container">            
        <form>
            <div class="form-group">
                <label for="complaintBody">Response to: <strong>Sample Thread 1</strong></label>
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