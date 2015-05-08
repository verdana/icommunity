<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../inc/header.inc.jsp" %>

<jsp:useBean id="house" class="com.modoop.data.entity.House" scope="request"/>

<div id="main-content" class="container">

    <ol class="breadcrumb">
        <li class="active">企业资源管理</li>
        <li><a href="${ctx}/house">户型管理</a></li>
       <li class="active">详细信息</li>
    </ol>

    <form id="form" action="#" method="post" class="form-horizontal content" role="form">
        <input type="hidden" name="id" value="${house.id}"/>

        <div class="form-group">
            <label class="control-label col-sm-3">户型<strong>*</strong></label>
            <div class="col-sm-4">
                <p class="form-control-static">${house.name}</p>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3">面积<strong>*</strong></label>
            <div class="col-sm-4">
                <p class="form-control-static">${house.area}</p>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3">价格<strong>*</strong></label>
            <div class="col-sm-4">
                <p class="form-control-static">${house.price}</p>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3">总价<strong>*</strong></label>
            <div class="col-sm-4">
                <p class="form-control-static">${house.totalPrice}</p>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3">折扣</label>
            <div class="col-sm-4">
                <p class="form-control-static">${house.discount}</p>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3">描述</label>
            <div class="col-sm-4">
                <p class="form-control-static">${house.description}</p>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3">创建时间</label>
            <div class="col-sm-4">
                <p class="form-control-static"><fmt:formatDate value="${house.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></p>
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