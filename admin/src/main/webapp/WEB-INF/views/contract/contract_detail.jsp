<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../inc/header.inc.jsp" %>

<jsp:useBean id="admin" class="com.modoop.data.entity.Admin" scope="request"/>

<div id="main-content" class="container">

    <ol class="breadcrumb">
        <li class="active">系统管理</li>
        <li><a href="${ctx}/contract">房产交易记录</a></li>
        <li class="active">详细信息</li>
    </ol>

    <form id="form" action="${ctx}/contract/update" method="post" class="form-horizontal content" role="form">
        <input type="hidden" name="id" value="${contract.id}"/>

        <div class="form-group">
            <label class="control-label col-sm-3">合同编号<strong>*</strong></label>
            <div class="col-sm-4">
                <p class="form-control-static">${contract.number}</p>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3">房屋总价</label>
            <div class="col-sm-4">
                <p class="form-control-static">${contract.price}</p>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3">交易时间</label>
            <div class="col-sm-4">
                <p class="form-control-static"><fmt:formatDate value="${contract.contractTime}" pattern="yyyy-MM-dd HH:mm:ss"/></p>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3">描述</label>
            <div class="col-sm-4">
                <p class="form-control-static">${contract.description}</p>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3">创建时间</label>
            <div class="col-sm-4">
                <p class="form-control-static"><fmt:formatDate value="${user.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></p>
            </div>
        </div>
        <div class="form-foot">
            <div class="btn-group">
                <button type="button" class="btn btn-default" onclick="back()">返回</button>
            </div>
        </div>
    </form>
</div>

<%@ include file="../inc/footer.inc.jsp" %>