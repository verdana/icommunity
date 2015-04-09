<%@ page import="com.modoop.data.entity.Permission" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../inc/header.inc.jsp" %>

<jsp:useBean id="role" class="com.modoop.data.entity.Role" scope="request"/>

<div id="main-content" class="container">

    <ol class="breadcrumb">
        <li class="active">系统管理</li>
        <li><a href="${ctx}/role">管理员权限管理</a></li>
        <li class="active">更新</li>
    </ol>

    <form id="form" action="${ctx}/role/update" method="post" class="form-horizontal content" role="form">
        <input type="hidden" name="id" value="${role.id}"/>
        <input type="hidden" name="name" value="${role.name}"/>
        <input type="hidden" name="version" value="${role.version}"/>

        <div class="form-group">
            <label class="control-label col-sm-3">名称<strong>*</strong></label>
            <div class="col-sm-4">
                <p class="form-control-static">${role.name}</p>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3" for="permissions">权限<strong>*</strong></label>
            <div class="col-sm-4">
                <%
                    List<Permission> permissions = (List<Permission>) request.getAttribute("permissions");
                    for (Permission permission : permissions)
                    {
                %>
                <div class="checkbox">
                    <label>
                        <input id="permissions" type="checkbox" name="permissions" value="<%=permission.getPermit()%>"
                        <%
                            if (role.getPermissionList().contains(permission.getPermit()))
                            {
                                out.print("checked");
                            }
                        %>
                        />
                        <%=permission.getName()%>
                    </label>
                </div>
                <%
                    }
                %>
                <label for="permissions" class="error"/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3" for="description">描述</label>
            <div class="col-sm-4">
                <textarea id="description" name="description" rows="5" class="form-control" maxlength="255">${role.description}</textarea>
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
                        permissions:  { required: true }
                    },
                    messages:
                    {
                        permissions: { required: '此处不能留空。'}
                    }
                });
    });

</script>

<%@ include file="../inc/footer.inc.jsp" %>