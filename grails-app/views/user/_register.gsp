<div class="row">
    <div class="panel panel-default">
        <div class="panel-heading panelHeaders">
            <span class="panelHeadersText">Register</span>
        </div>

        <div class="panel-body">
            <g:uploadForm class="form-horizontal" name = "registrationForm" controller = "login" action = "register">
                <div class="form-group row">
                    <label class="form-control-label">Full name</label>
                    <div>
                        <input name = "name" id = "name" type="text" value = "${user?.name}" class="form-control" required = "required">
                    </div>
                    <div class="alert-danger"> <g:fieldError field="name" bean="${user}"/></div>
                </div>

                <div class="form-group row">
                    <label class="form-control-label">Email</label>
                    <div>
                        <input name = "emailID" id = "emailID" type="email" value = "${user?.emailID}" class="form-control" required = "required">
                    </div>
                    <div class="alert-danger"> <g:fieldError field="emailID" bean="${user}"/></div>
                </div>

                <div class="form-group row">
                    <label class="form-control-label">Username</label>
                    <div>
                        <input name = "userName" id = "userName" type="text" value = "${user?.username}" class="form-control" required = "required">
                    </div>
                    <div class="alert-danger"> <g:fieldError field="username" bean="${user}"/></div>
                </div>

                <div class="form-group row">
                    <label class="form-control-label">Age</label>
                    <div>
                        <input name = "age" id = "age" type="number" min="0" max="100" value = "${user?.age}" class="form-control" required = "required">
                    </div>
                    <div class="alert-danger"> <g:fieldError field="age" bean="${user}"/></div>
                </div>

                <div class="form-group row">
                    <label class="form-control-label">Profile photo</label>
                    <div>
                        <input type="file" accept="image/jpeg,image/png,jpg|png" id = "pic" name = "pic" class="form-control">
                    </div>
                </div>

                <div class="form-group row">
                    <label name class="form-control-label">Password</label>
                    <div>
                        <g:field type="password" minlength="5" maxlength="20" name="password" id="password" class="form-control" required = "required"/>
                    </div>
                    <div class="alert-danger"> <g:fieldError field="password" bean="${user}"/></div>
                </div>

                <div class="form-group row">
                    <div class="col-xs-offset-4">
                        <br/><input type="submit" class="btn btn-primary" value="Register" />
                    </div>
                </div>
            </g:uploadForm>
        </div>
    </div>
</div>
