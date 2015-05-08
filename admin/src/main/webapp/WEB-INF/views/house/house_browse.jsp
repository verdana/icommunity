<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../inc/header.inc.jsp" %>

<div id="main-content" class="container">

    <ol class="breadcrumb">
        <li class="active">企业资源管理</li>
        <li><a href="${ctx}/house">户型管理</a></li>
        <li class="active">浏览</li>
    </ol>

    <c:if test="${not empty message}">
        <div id="message" class="alert alert-success">${message}</div>
    </c:if>

    <div class="row content">
        <div class="col-xs-6 col-md-4">
            <shiro:hasPermission name="house:change">
                <div class="pull-left btn-group">
                    <button type="button" id="create" class="btn btn-default" onclick="redirect('${ctx}/house/create')">创建</button>
                    <button type="button" id="edit" class="btn btn-default sbtn" onclick="redirect('${ctx}/house/update/' + get_checked_value('form'))" disabled="disabled">更新</button>
                    <button type="button" id="delete" class="btn btn-default mbtn" onclick="confirm_submit($('#form'), '${ctx}/house/delete')">删除</button>
                </div>
            </shiro:hasPermission>
        </div>
        <div class="col-xs-6 col-md-offset-6 col-md-4 col-md-offset-4">
            <form action="${ctx}/house" method="get">
                <div class="input-group">
                    <input class="form-control" type="text" name="search_name" placeholder="户型" value="${params.name}"/>
                    <span class="input-group-btn">
                        <button class="btn btn-default" type="submit">查询</button>
                    </span>
                </div>
            </form>
        </div>
    </div>

    <form id="form" method="post">
        <table class="table table-striped table-hover data">
            <thead>
            <tr>
                <th></th>
                <th style="width: 15%">户型</th>
                <th style="width: 10%">面积</th>
                <th style="width: 10%">价格</th>
                <th style="width: 10%">总价</th>
                <th style="width: 10%">折扣</th>
                <th style="width: 10%">折扣价</th>
                <th>创建时间</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${houses.content}" var="house">
                <tr>
                    <td><shiro:hasPermission name="house:change"><input type="checkbox" id="chk_${house.id}" name="id" value="${house.id}" onclick="update_button_status()"/></shiro:hasPermission></td>
                    <td><a href="${ctx}/house/detail/${house.id}">${house.name}</a></td>
                    <td>${house.area}</td>
                    <td>${house.price}</td>
                    <td>${house.totalPrice}</td>
                    <td>${house.discount}</td>
                    <td>${house.totalPrice*house.discount}</td>
                    <td><fmt:formatDate value="${house.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </form>

    <div class="row">
        <div class="col-xs-6 col-md-4">
            第 <b>${houses.number * houses.size + 1} - ${houses.number * houses.size + houses.numberOfElements}</b> 条，共 <b>${houses.totalElements}</b> 条
        </div>
        <div class="col-xs-6 col-md-4 col-md-offset-4" style="text-align: right">
            <html:pagination name="pagination" page="${houses}" paginationSize="5" classname="pagination" style="margin: 0"/>
        </div>
    </div>

</div>

<%@ include file="../inc/footer.inc.jsp" %>