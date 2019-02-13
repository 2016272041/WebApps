<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Java Servlet Cookie Example</title>
        <style type="text/css">
            .paddingBtm {
                padding-bottom: 12px;
            }
        </style>
    </head>
    <body>
        <center>
            <h2>Java Servlet Cookie Example</h2>
            <form id="loginFormId" name="loginForm" method="post" action="helloFormServlet">
                <div id="usernameDiv" class="paddingBtm">
                    <span id="user">First Name: </span><input type="text" name="first_name" />
                </div>
                <div id="passwordDiv" class="paddingBtm">
                    <span id="pass">Last Name: </span><input type="text" name="last_name" />
                </div>
                <div id="loginBtn">
                    <input id="btn" type="submit" value="Submit" />
                </div>
            </form>
        </center>
    </body>
</html>