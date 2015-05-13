<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../inc/header.inc.jsp" %>

<div id="main-content" class="container">

    <ol class="breadcrumb">
        <li class="active">系统管理</li>
        <li><a href="${ctx}/contract">房产交易记录</a></li>
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
            <form action="${ctx}/contract" method="get">
                <div class="input-group">
                    <input class="form-control" type="text" name="search_number" placeholder="合同编号" value="${params.name}"/>
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
                <th style="width: 20%">合同编号</th>
                <th style="width: 15%">房屋总价</th>
                <th style="width: 15%">交易日期</th>
                <th>创建时间</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${contracts.content}" var="contract">
                <tr>
                    <td><shiro:hasPermission name="contract:change"><input type="checkbox" id="chk_${contract.id}" name="id" value="${contract.id}" onclick="update_button_status()"/></shiro:hasPermission></td>
                    <td><a href="${ctx}/contract/detail/${contract.id}">${contract.number}</a></td>
                    <td>${contract.price}</td>
                    <td><fmt:formatDate value="${contract.contractTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    <td><fmt:formatDate value="${contract.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </form>

    <div class="row">
        <div class="col-xs-6 col-md-4">
            第 <b>${contracts.totalElements != 0 ? contracts.number * contracts.size + 1 : 0} - ${contracts.number * contracts.size + contracts.numberOfElements}</b> 条，共 <b>${contracts.totalElements}</b> 条
        </div>
        <div class="col-xs-6 col-md-4 col-md-offset-4" style="text-align: right">
            <html:pagination name="pagination" page="${contracts}" paginationSize="5" classname="pagination" style="margin: 0"/>
        </div>
    </div>

</div>

<%@ include file="../inc/footer.inc.jsp" %>