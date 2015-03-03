<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../inc/header.inc.jsp" %>

<div id="main-content" class="container">

    <ol class="breadcrumb">
        <li class="active">系统管理</li>
        <li><a href="${ctx}/role">角色管理</a></li>
        <li class="active">浏览</li>
    </ol>

    <c:if test="${not empty message}">
        <div id="message" class="alert alert-success">${message}</div>
    </c:if>

    <div class="row content">
        <div class="col-md-4">
            <shiro:hasPermission name="admin:change">
                <div class="pull-left btn-group">
                    <button type="button" id="create" class="btn btn-default" onclick="redirect('${ctx}/role/create')">创建</button>
                    <button type="button" id="edit" class="btn btn-default sbtn" onclick="redirect('${ctx}/role/update/' + get_checked_value('form'))" disabled="disabled">更新</button>
                    <button type="button" id="delete" class="btn btn-default mbtn" onclick="confirm_submit($('#form'), '${ctx}/role/delete')">删除</button>
                </div>
            </shiro:hasPermission>
        </div>
        <div class="col-md-4 col-md-offset-4">
            <form action="${ctx}/role/" method="get">
                <div class="input-group">
                    <input class="form-control" type="text" name="search_name" placeholder="名称" value="${params.name}"/>
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
                <th style="width: 15%">名称</th>
                <th style="width: 50%">描述</th>
                <th>创建时间</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${roles.content}" var="role">
                <tr>
                    <td><input type="checkbox" id="chk_${role.id}" name="id" value="${role.id}" onclick="update_button_status()" <shiro:lacksPermission name="admin:change">disabled</shiro:lacksPermission>/></td>
                    <td><a id="review" href="${ctx}/role/detail/${role.id}">${role.name}</a></td>
                    <td>${role.description}</td>
                    <td><fmt:formatDate value="${role.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </form>

    <div class="row">
        <div class="col-md-4">
            第 <b>${roles.number * roles.size + 1} - ${roles.number * roles.size + roles.numberOfElements}</b> 条，共 <b>${roles.totalElements}</b> 条
        </div>
        <div class="col-md-4 col-md-offset-4" style="text-align: right">
            <html:pagination name="pagination" page="${roles}" paginationSize="5" classname="pagination" style="margin: 0"/>
        </div>
    </div>

</div>

<%@ include file="../inc/footer.inc.jsp" %>