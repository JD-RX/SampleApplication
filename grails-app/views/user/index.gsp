<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <meta name="layout" content="main">
        <title>${user.name}</title>
    </head>
    <body>
            <div class="row">
                <div class="row panel panel-default panel-body">
                        <g:render template = "/user/show" model = "[user : user]"/>
                </div>
            </div>
    </body>
</html>