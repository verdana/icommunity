<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../inc/header.inc.jsp" %>

<div id="main-content" class="container">

    <ol class="breadcrumb">
        <li class="active">系统管理</li>
        <li><a href="${ctx}/user">用户管理</a></li>
        <li class="active">浏览</li>
    </ol>

    <c:if test="${not empty message}">
        <div id="message" class="alert alert-success">${message}</div>
    </c:if>

    <div class="row content">
        <div class="col-xs-6 col-md-4">
            <%--<shiro:hasPermission name="user:change">--%>
                <%--<div class="pull-left btn-group">--%>
                    <%--<button type="button" id="edit" class="btn btn-default sbtn" onclick="redirect('${ctx}/user/update/' + get_checked_value('form'))" disabled="disabled">更新</button>--%>
                    <%--<button type="button" id="delete" class="btn btn-default mbtn" onclick="confirm_submit($('#form'), '${ctx}/user/delete')">删除</button>--%>
                <%--</div>--%>
            <%--</shiro:hasPermission>--%>
        </div>
        <div class="col-xs-6 col-md-offset-6 col-md-4 col-md-offset-4">
            <form action="${ctx}/user" method="get">
                <div class="input-group">
                    <input class="form-control" type="text" name="search_true_name" placeholder="真实姓名" value="${params.name}"/>
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
                <th style="width: 20%">真实姓名</th>
                <th style="width: 15%">手机</th>
                <th style="width: 15%">邮箱</th>
                <th>创建时间</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${users.content}" var="user">
                <tr>
                    <td><shiro:hasPermission name="user:change"><input type="checkbox" id="chk_${admin.id}" name="id" value="${admin.id}" onclick="update_button_status()"/></shiro:hasPermission></td>
                    <td><a href="${ctx}/user/detail/${user.id}">${user.trueName}</a></td>
                    <td>${user.mobile}</td>
                    <td>${user.email}</td>
                    <td><fmt:formatDate value="${user.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </form>

    <div class="row">
        <div class="col-xs-6 col-md-4">
            第 <b>${users.totalElements != 0 ? users.number * users.size + 1 : 0} - ${users.number * users.size + users.numberOfElements}</b> 条，共 <b>${users.totalElements}</b> 条
        </div>
        <div class="col-xs-6 col-md-4 col-md-offset-4" style="text-align: right">
            <html:pagination name="pagination" page="${users}" paginationSize="5" classname="pagination" style="margin: 0"/>
        </div>
    </div>

</div>

<%@ include file="../inc/footer.inc.jsp" %>