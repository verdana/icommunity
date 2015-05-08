<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../inc/header.inc.jsp" %>

<jsp:useBean id="admin" class="com.modoop.data.entity.Admin" scope="request"/>

<div id="main-content" class="container">

    <ol class="breadcrumb">
        <li class="active">系统管理</li>
        <li><a href="${ctx}/user">管理员管理</a></li>
        <li class="active">详细信息</li>
    </ol>

    <form id="form" action="${ctx}/user/update" method="post" class="form-horizontal content" role="form">
        <input type="hidden" name="id" value="${user.id}"/>

        <div class="form-group">
            <label class="control-label col-sm-3">真实姓名</label>
            <div class="col-sm-4">
                <p class="form-control-static">${user.trueName}</p>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3">手机<strong>*</strong></label>
            <div class="col-sm-4">
                <p class="form-control-static">${user.mobile}</p>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3">系统帐号</label>
            <div class="col-sm-4">
                <p class="form-control-static">${user.name}</p>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3">昵称</label>
            <div class="col-sm-4">
                <p class="form-control-static">${user.nickName}</p>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3">身份证号</label>
            <div class="col-sm-4">
                <p class="form-control-static">${user.idCard}</p>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3">性别</label>
            <div class="col-sm-4">
                <p class="form-control-static">${user.gender}</p>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3">年龄</label>
            <div class="col-sm-4">
                <p class="form-control-static">${user.age}</p>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3">电话号码</label>
            <div class="col-sm-4">
                <p class="form-control-static">${user.phone}</p>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3">电子邮箱</label>
            <div class="col-sm-4">
                <p class="form-control-static">${user.email}</p>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3">描述</label>
            <div class="col-sm-4">
                <p class="form-control-static">${user.description}</p>
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