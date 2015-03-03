<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../inc/header.inc.jsp" %>

<jsp:useBean id="admin" class="com.modoop.admin.entity.Admin" scope="request"/>

<div id="main-content" class="container">

    <ol class="breadcrumb">
        <li class="active">系统管理</li>
        <li><a href="${ctx}/admin">管理员管理</a></li>
        <li class="active">详细信息</li>
    </ol>

    <form id="form" action="${ctx}/user/update" method="post" class="form-horizontal content" role="form">
        <input type="hidden" name="id" value="${admin.id}"/>

        <div class="form-group">
            <label class="control-label col-sm-3">帐号<strong>*</strong></label>
            <div class="col-sm-4">
                <p class="form-control-static">${admin.name}</p>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3">真实姓名</label>
            <div class="col-sm-4">
                <p class="form-control-static">${admin.trueName}</p>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3">电话号码</label>
            <div class="col-sm-4">
                <p class="form-control-static">${admin.phone}</p>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3">手机</label>
            <div class="col-sm-4">
                <p class="form-control-static">${admin.mobile}</p>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3">电子邮箱</label>
            <div class="col-sm-4">
                <p class="form-control-static">${admin.email}</p>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3">状态</label>
            <div class="col-sm-4">
                <p class="form-control-static"><%=getStateText(admin.getState())%></p>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3">角色</label>
            <div class="col-sm-4">
                <p class="form-control-static">${admin.role.name}</p>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3">描述</label>
            <div class="col-sm-4">
                <p class="form-control-static">${admin.description}</p>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3">创建时间</label>
            <div class="col-sm-4">
                <p class="form-control-static"><fmt:formatDate value="${admin.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></p>
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