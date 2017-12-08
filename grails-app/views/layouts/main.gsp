<!doctype html>
<html lang="en" class="no-js">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
        <title>
            <g:layoutTitle default="Grails"/>
        </title>
        <meta name="viewport" content="width=device-width, initial-scale=1"/>

        <asset:stylesheet src="sample.css"/>
        <asset:stylesheet src="application.css"/>
        <asset:stylesheet src="bootstrap.css"/>
        <asset:javascript src="jquery-2.2.0.min.js"/>

        <g:layoutHead/>
    </head>
    <body>
        <div class="navbar navbar-default navbar-static-top" role="navigation">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <g:link controller = "login" action = "index" class = "navbar-brand navBarHeaderBrand">
                        <i class="fa grails-icon">
                            <asset:image src="grails-cupsonly-logo-white.svg"/>
                        </i> Sample Application
                    </g:link>

                </div>
                <div class="navbar-brand nav navbar-nav navbar-right">
                    <g:if test = "${session.user}">
                        <i class="fa grails-icon">
                            <g:link controller="logoff">Logout</g:link>
                        </i>
                    </g:if>
                </div>
                <div class="navbar-collapse collapse" aria-expanded="false" style="height: 0.8px;">
                    <ul class="nav navbar-nav navbar-right">
                        <g:pageProperty name="page.nav" />
                    </ul>
                </div>
            </div>
        </div>
        <g:if test="${flash.message}">
            <div class="alert alert-success alert-dismissable">
                <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span
                        aria-hidden="true">X</span></button>
                ${flash.message}
            </div>
        </g:if>
        <g:if test="${flash.error}">
            <div class="alert alert-danger alert-warning alert-dismissable">
                <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span
                        aria-hidden="true">X</span></button>
                ${flash.error}
            </div>
        </g:if>
        <div class="container">
            <g:layoutBody/>
        </div>
        <div class="footer" role="contentinfo"></div>

        <div id="spinner" class="spinner" style="display:none;">
            <g:message code="spinner.alt" default="Loading&hellip;"/>
        </div>

        <asset:javascript src="application.js"/>
        <asset:javascript src="bootstrap.js"/>
    </body>
</html>
