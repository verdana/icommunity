<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.slf4j.Logger,org.slf4j.LoggerFactory" %>
<%@ include file="../inc/header.inc.jsp" %>
<%
    //设置返回码200，避免浏览器自带的错误页面
    response.setStatus(200);
    //记录日志
    Logger logger = LoggerFactory.getLogger("500.jsp");
    String message = exception.getMessage();
    logger.error(message);
//    logger.error(message, exception);
%>

<div id="main-content" class="container">

    <ul class="breadcrumb">
        <li class="active title">系统内部错误</li>
    </ul>

    <div class="alert alert-block alert-error fade in well">
        <h4>500 - 系统发生内部错误</h4>
        <p class="alert-content">如果有疑问，请联系管理员协助解决您的问题。</p>
    </div>

    <p>
        <button type="button" class="btn btn-danger" onclick="back();" >返回</button>
    </p>

</div>

<%@ include file="../inc/footer.inc.jsp" %>
