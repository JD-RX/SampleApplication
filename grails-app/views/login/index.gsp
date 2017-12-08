<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <meta name="layout" content="main">
        <title>Home Page</title>
    </head>

    <body>
        <div>
            <div class="row">
                <div class="col-xs-6">
                    <g:render template="/user/login"/>
                </div>
                <div class="col-xs-6">
                    <g:render template="/user/register"/>
                </div>
            </div>
        </div>
    </body>
</html>