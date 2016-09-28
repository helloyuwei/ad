<%@ include file="include/header.jsp" %>

<div class="container-fluid-full">
    <div class="row-fluid">

        <div class="row-fluid">
            <div class="login-box">
                <div class="icons">
                    <a href="index.html"><i class="halflings-icon home"></i></a>
                    <a href="#"><i class="halflings-icon cog"></i></a>
                </div>
                <h2>重置密码</h2>
                <form class="form-horizontal" action="${ctx}${adminPath}/sendResetPassword" method="post">
                    <fieldset>

                        <div class="input-prepend" title="账号">
                            <span class="add-on"><i class="halflings-icon user"></i></span>
                            <input class="input-large span10" name="loginName" id="loginName" type="text"
                                   placeholder="请输入登录账号"/>
                        </div>

                        <div class="clearfix"></div>

                        <div class="input-prepend" title="邮箱">
                            <span class="add-on"><i class="halflings-icon e-mail"></i></span>
                            <input class="input-large span10" name="email" id="email" type="text"
                                   placeholder="邮箱"/>
                        </div>

                        <div class="clearfix"></div>

                        <div class="input-prepend" title="verifyCode">
                            <span class="add-on"><i class="halflings-icon lock"></i></span>
                            <input class="input-large span8" name="verifyCode" id="verifyCode" type="text"
                                   placeholder="请输入验证信息"/>
                            <img class="span2" src="${ctx}${adminPath}/getVerifyCodeImage"/>
                        </div>

                        <div class="clearfix"></div>

                        <div class="button">
                            <button type="submit" class="btn btn-primary">重置密码</button>
                        </div>
                        <div class="clearfix"></div>
                    </fieldset>
                </form>
            </div><!--/span-->
        </div><!--/row-->


    </div><!--/.fluid-container-->

</div>
<!--/fluid-row-->

<%@ include file="include/footer.jspf" %>

