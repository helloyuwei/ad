<%@ include file="include/header.jsp" %>
<style type="text/css">
    body {
        background: url(${ctx}${staticPath}/img/bg-login.jpg) !important;
    }
</style>

<div class="container-fluid-full">
    <div class="row-fluid">

        <div class="row-fluid">
            <div class="login-box">
                <div class="icons">
                    <a href="index.html"><i class="halflings-icon home"></i></a>
                    <a href="#"><i class="halflings-icon cog"></i></a>
                </div>
                <h2>Login to your account</h2>
                <form class="form-horizontal" action="${ctx}${adminPath}/login" method="post">
                    <fieldset>

                        <div class="input-prepend" title="Username">
                            <span class="add-on"><i class="halflings-icon user"></i></span>
                            <input class="input-large span10" name="loginName" id="loginName" type="text"
                                   placeholder="请输入登录账号"/>
                        </div>
                        <div class="clearfix"></div>

                        <div class="input-prepend" title="Password">
                            <span class="add-on"><i class="halflings-icon lock"></i></span>
                            <input class="input-large span10" name="password" id="password" type="password"
                                   placeholder="请输入密码"/>
                        </div>
                        <div class="clearfix"></div>

                        <div class="input-prepend" title="Password">
                            <span class="add-on"><i class="halflings-icon lock"></i></span>
                            <input class="input-large span8" name="verifyCode" id="verifyCode" type="text" placeholder="请输入验证信息"/>
                            <img class="span2" src="${ctx}${adminPath}/getVerifyCodeImage"/>
                        </div>
                        <div class="clearfix"></div>

                        <label class="remember" for="rememberMe">
                            <input type="checkbox" name="rememberMe" id="rememberMe" value="true"/>记住我</label>

                        <div class="button-login">
                            <button type="submit" class="btn btn-primary">Login</button>
                        </div>
                        <div class="clearfix"></div>
                    </fieldset>
                </form>
                <hr>
                <h3>忘记密码?</h3>
                <p>
                   没关系, <a href="#">点击我</a> 获取新密码.
                </p>
            </div><!--/span-->
        </div><!--/row-->


    </div><!--/.fluid-container-->

</div><!--/fluid-row-->


<%@ include file="include/footer.jspf" %>