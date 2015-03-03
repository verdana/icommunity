<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../inc/header.inc.jsp" %>

<div id="main-content" class="container">

    <ul class="breadcrumb">
        <li class="active title">请求失败</li>
    </ul>

    <div class="alert alert-block alert-error fade in well">
        <h4>404 - 访问的页面不存在.</h4>
        <p class="alert-content">请求所希望得到的资源未被在服务器上发现，资源不存在或已经被删除。请返回尝试其它地址。</p>
    </div>

    <p>
        <button type="button" class="btn btn-danger" onclick="home();" >返回首页</button>
    </p>

</div>

<%@ include file="../inc/footer.inc.jsp" %>
