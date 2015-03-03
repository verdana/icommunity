<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="../inc/header.inc.jsp" %>

<div id="main-content" class="container">

    <ol class="breadcrumb">
        <li class="active">系统管理</li>
        <li><a href="${ctx}/admin">角色管理</a></li>
        <li class="active">创建</li>
    </ol>

    <form id="form" action="${ctx}/role/create" method="post" class="form-horizontal content" role="form">
        <div class="form-group">
            <label class="control-label col-sm-3" for="name">名称<strong>*</strong></label>
            <div class="col-sm-4">
                <input type="text" id="name" name="name" class="form-control" maxlength="63"/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3" for="permissions">权限<strong>*</strong></label>
            <div class="col-sm-4">
                <c:forEach items="${permissions}" var="permission">
                    <div class="checkbox">
                        <label>
                            <input id="permissions" type="checkbox" name="permissions" value="${permission.permit}">
                            ${permission.name}
                        </label>
                    </div>
                </c:forEach>
                <label for="permissions" class="error"/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3" for="description">描述</label>
            <div class="col-sm-4">
                <textarea id="description" name="description" rows="5" class="form-control" maxlength="255"></textarea>
            </div>
        </div>
        <div class="form-foot">
            <div class="btn-group">
                <button type="submit" class="btn btn-primary">保存</button>
                <button type="reset" class="btn btn-default">重置</button>
                <button type="button" class="btn btn-default" onclick="back()">返回</button>
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
                name: { required: true },
                permissions:  { required: true }
            },
            messages:
            {
                name: { required: '此处不能留空。' },
                permissions: { required: '此处不能留空。' }
            }
        });
    });

</script>

<%@ include file="../inc/footer.inc.jsp" %>