<div class="row">
    <div class="col-xs-2">
        <img style="width:80px;height:90px;" src="/user/image/${tweet.ownerId}" class="img img-thumbnail img-responsive image" />
    </div>
    <div class="col-xs-8">
        <div class="row">
            <div class = "col-xs-10">
                    <g:link title="${tweet.ownerName}" class="tweetUserName" controller = "user" action = "profile" params = "[id: tweet.ownerId]">@${tweet.ownerUserName} </g:link>
                    on <g:formatDate class="tweetDate text-primary" format="E, dd MMM yyyy" date="${tweet.createdDate}" type="datetime" style="LONG" timeStyle="SHORT"/>
            </div>
        </div>

        <div class="row">
            <div class = "col-xs-12">
                <div id = "message" class="text-justify tweetMessage">${tweet.message}</div>
            </div>
        </div>
    </div>
    <div class="col-xs-2">
        <sa:showFollowButton userId="${tweet.ownerId}" userName="${tweet.ownerName}"/>
        <g:if test="${tweet.ownerId == session.user?.id}">
            <button title="Delete tweet" tweetId="${tweet.id}" data-toggle="modal" class="btn btn-danger tweetDelete">X</button>
        </g:if>
    </div>
</div>
<div class = "row">&nbsp;<hr/></div>
<g:render template="/tweet/confirmation"/>
<script type="text/javascript">
        $(document).ready(function(){
            $(".tweetDelete").click(function (e) {
                e.preventDefault();
                var tweetId = $(this).attr('tweetId');
                $("#deleteConfirmationModal #id").val(tweetId);
                $("#deleteConfirmationModal").modal('show');
            })
        });
</script>
