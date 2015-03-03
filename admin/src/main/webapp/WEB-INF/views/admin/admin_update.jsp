<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../inc/header.inc.jsp" %>

<div id="main-content" class="container">

    <ol class="breadcrumb">
        <li class="active">系统管理</li>
        <li><a href="${ctx}/admin">管理员管理</a></li>
        <li class="active">更新</li>
    </ol>

    <form id="form" action="${ctx}/admin/update" method="post" class="form-horizontal content" role="form">
        <input type="hidden" name="id" value="${admin.id}"/>
        <input type="hidden" name="name" value="${admin.name}"/>
        <input type="hidden" name="version" value="${admin.version}"/>

        <div class="form-group">
            <label class="control-label col-sm-3">帐号<strong>*</strong></label>
            <div class="col-sm-4">
                <p class="form-control-static">${admin.name}</p>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3" for="trueName">真实姓名</label>
            <div class="col-sm-4">
                <input type="text" id="trueName" name="trueName" value="${admin.trueName}" class="form-control" maxlength="63"/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3" for="phone">电话号码</label>
            <div class="col-sm-4">
                <input type="text" id="phone" name="phone" value="${admin.phone}" class="form-control" maxlength="20"/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3" for="mobile">手机</label>
            <div class="col-sm-4">
                <input type="text" id="mobile" name="mobile" value="${admin.mobile}" class="form-control" maxlength="20"/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3" for="email">电子邮箱</label>
            <div class="col-sm-4">
                <input type="text" id="email" name="email" value="${admin.email}" class="form-control" maxlength="127" rel="popover" data-content="请输入如 username@domain.ext 格式。"/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3">状态</label>
            <div class="col-sm-4">
                <html:select id="state" name="state" options="<%=Stateful.TEXT%>" selected="${admin.state}" classname="form-control" hasBlankOption="false" hasNaOption="false"/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3" for="roleId">Role<strong>*</strong></label>
            <div class="col-sm-4">
                <select id="roleId" name="roleId" class="form-control">
                    <c:forEach items="${roles}" var="role">
                        <option value="${role.id}"<c:if test="${admin.role.id == role.id}"> selected="true"</c:if>>${role.name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3" for="description">描述</label>
            <div class="col-sm-4">
                <textarea id="description" name="description" rows="5" class="form-control" maxlength="255">${admin.description}</textarea>
            </div>
        </div>
        <div class="form-foot">
            <div class="btn-group">
                <button type="submit" class="btn btn-primary">保存</button>
                <button type="reset" class="btn btn-default">重置</button>
                <button type="button" class="btn btn-default" onclick="back()">后退</button>
            </div>
        </div>
    </form>
</div>

<script>

    $(function()
    {
        $('#form').validate(
                {
                    onkeyup: false,
                    rules:
                    {
                        email:  { email: true }
                    },
                    messages:
                    {
                        email: { email: '请输入合法的电子邮箱地址。'}
                    }
                });
    });

</script>

<%@ include file="../inc/footer.inc.jsp" %>