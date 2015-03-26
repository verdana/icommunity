<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../inc/header.inc.jsp" %>

<div id="main-content" class="container">

    <ul class="breadcrumb">
        <li class="active title">错误请求</li>
    </ul>

    <div class="alert alert-block alert-error fade in well">
        <h4>400 - 请求数据错误.</h4>
        <p class="alert-content">请求的数据有错误，请检查并重新输入。</p>
    </div>

    <p>
        <button type="button" class="btn btn-danger" onclick="back();" >返回上页</button>
    </p>

</div>

<%@ include file="../inc/footer.inc.jsp" %>
