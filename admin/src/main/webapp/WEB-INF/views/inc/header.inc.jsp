<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="html" uri="http://www.modoop.com/html/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="./lib.inc.jsp" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>系统管理中心</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="author" content="Genkyo Lee"/>
    <meta HTTP-EQUIV="pragma" CONTENT="no-cache">
    <meta HTTP-EQUIV="Cache-Control" CONTENT="no-cache, must-revalidate">
    <meta HTTP-EQUIV="expires" CONTENT="0">
    <meta name="description" content="">
    <link type="image/x-icon" href="${ctx}/static/modoop/img/favicon.ico" rel="shortcut icon">
    <link href="${ctx}/static/bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="${ctx}/static/bootstrap/css/todc-bootstrap.min.css" rel="stylesheet"/>
    <link href="${ctx}/static/bootstrap/css/select2.css" rel="stylesheet"/>
    <link href="${ctx}/static/modoop/css/style.css" rel="stylesheet"/>

    <script type="text/javascript" src="${ctx}/static/jquery/js/jquery.min.js"></script>
    <script type="text/javascript" src="${ctx}/static/jquery/js/jquery.validate.min.js"></script>
    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script type="text/javascript" src="${ctx}/static/google/js/html5shiv.min.js"></script>
    <![endif]-->
</head>

<body>

<nav class="navbar navbar-default" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <!-- Brand and toggle get grouped for better mobile display -->
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="${ctx}/">首页</a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">系统管理 <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <shiro:hasPermission name="admin:read"><li><a href="${ctx}/admin">管理员管理</a></li></shiro:hasPermission>
                        <shiro:hasPermission name="role:read"><li><a href="${ctx}/role">角色管理</a></li></shiro:hasPermission>
                    </ul>
                </li>
                <li>
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">企业资源管理 <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <shiro:hasPermission name="role:read"><li><a href="${ctx}/house">楼盘户型管理</a></li></shiro:hasPermission>
                        <shiro:hasPermission name="admin:read"><li><a href="${ctx}/saler">销售人员管理</a></li></shiro:hasPermission>
                        <shiro:hasPermission name="role:read"><li><a href="${ctx}/broker">中介人员管理</a></li></shiro:hasPermission>
                    </ul>
                </li>
                <li>
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">财务管理 <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <shiro:hasPermission name="admin:read"><li><a href="${ctx}/contract">房产交易记录</a></li></shiro:hasPermission>
                        <shiro:hasPermission name="admin:read"><li><a href="${ctx}/record">财务记录</a></li></shiro:hasPermission>
                    </ul>
                </li>
                <li>
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">用户管理 <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <shiro:hasPermission name="admin:read"><li><a href="${ctx}/user">客户管理</a></li></shiro:hasPermission>
                    </ul>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <shiro:user>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><b><shiro:principal property="name"/></b> <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="${ctx}/admin/selfupdate">个人信息</a></li>
                        <li class="divider"></li>
                        <li><a href="${ctx}/logout">退出</a></li>
                    </ul>
                </li>
                </shiro:user>
            </ul>
        </div>
    </div>
</nav>