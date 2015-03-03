<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="org.apache.shiro.web.filter.authc.FormAuthenticationFilter"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>系统管理中心</title>
    <meta name="viewport" content="width=1024"/>
    <meta name="description" content=""/>
    <meta name="author" content="Roger Lee"/>
    <link type="image/x-icon" href="${ctx}/static/avalon/img/favicon.ico" rel="shortcut icon">
    <link href="${ctx}/static/bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="${ctx}/static/bootstrap/css/todc-bootstrap.min.css" rel="stylesheet"/>
    <link href="${ctx}/static/modoop/css/sticky.css" rel="stylesheet"/>
    <link href="${ctx}/static/modoop/css/style.css" rel="stylesheet"/>
    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script type="text/javascript" src="${ctx}/static/google/js/html5shiv.js"></script>
    <![endif]-->
</head>

<body>

<div id="wrap">

    <div class="navbar navbar-default navbar-static-top">
        <div class="container">
        </div>
    </div>

    <div id="content-login" class="container">
        <form class="form-signin" action="${ctx}/login" method="post">
            <div class="form-group text-center" style="padding: 20px 0">
                <img width="120px" height="120px" src="${ctx}/static/modoop/img/avatar_2x.png" alt="Log-In" class="img-circle">
            </div>
            <div class="form-group">
                <label for="username" class="required">帐号</label>
                <input type="text" id="username" name="username" value="${username}" class="form-control" placeholder="管理员账号"/>
            </div>
            <div class="form-group">
                <label for="password" class="required">密码</label>
                <input type="password" id="password" name="password" class="form-control" placeholder="管理员密码"/>
            </div>
            <%
                String error = (String) request.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
                if (error != null)
                {
            %>
            <div class="callout callout-danger">
                <%
                    if (error.contains("DisabledAccountException"))
                    {
                        out.print("用户已被屏蔽，请登录其他用户。");
                    }
                    else
                    {
                        out.print("登录失败，请重试。");
                    }
                %>
            </div>
            <%
                }
            %>
            <div class="form-group">
                <button id="submit" class="btn btn-success btn-block" type="submit" style="padding: 7px 40px;">登录</button>
            </div>
            <div class="checkbox" style="min-height:30px">
                <label>
                    <input type="checkbox" id="rememberMe" name="rememberMe"/> 保持登录状态
                </label>
            </div>
        </form>
    </div>

</div>

<div id="footer">
    <div class="container">
        <p class="left pull-left text-muted">&copy; 2013 Modoop</p>
    </div>
</div>

<script type="text/javascript" src="${ctx}/static/jquery/js/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/static/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${ctx}/static/modoop/js/modoop.js"></script>

<script>
    $(function()
    {
        //聚焦第一个输入框
        $("#username").focus();
    });
</script>

</body>
</html>