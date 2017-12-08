<div class="row">
    <div class="col-xs-6">
        <div class="col-xs-3">
            <img style="width:80px;height:90px;" src="/user/image/${user.userId}" class="img img-thumbnail img-responsive image" />
        </div>
        <div class="col-xs-3">
            <div class="row">
                <div class="col-xs-12 text-primary">
                    <span class="text-capitalize" style="color:#67b168">${user.name}</span>
                </div>
            </div>

            <div class="row">
                <div class="col-xs-12 text-primary">
                    <small>(@${user.userName})</small>
                </div>
            </div>
        </div>
    </div>

    <div class="col-xs-6">
        <g:if test="${user.userId == session.user?.id}">
            <g:form class="form" controller="tweet" action="save">
                <div class="form-group row">
                        <g:textArea id="message" name="message" class="form-control" required="true"/>
                </div>
                <div>&nbsp;</div>
                <div class="form-group row">
                    <div class="col-xs-offset-4 col-xs-4">
                        <g:submitButton title="Add tweet" class="btn btn-primary submitButtons" type="submit"
                                        name="submit" value="Tweet"/>
                    </div>
                </div>
            </g:form>
        </g:if>
    </div>
</div>
<div class = "row">&nbsp;</div>
<div class="row">
    <g:if test="${tweets.size()}">
        <div class="panel panel-default">
            <div class="panel-heading panelHeaders">
                <span class = "panelHeadersText">Tweets</span>
            </div>

            <div class="panel-body">
                <g:each in="${tweets}" var="tweet">
                    <g:render template="/tweet/show" model="[tweet : tweet]" />
                </g:each>
            </div>
        </div>
    </g:if>
</div>

<script type="text/javascript">
    $('#message').click(function(){
        $(this).attr('disabled');
    });
</script>