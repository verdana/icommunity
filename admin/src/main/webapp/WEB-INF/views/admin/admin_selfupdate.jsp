<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../inc/header.inc.jsp" %>

<jsp:useBean id="admin" class="com.modoop.data.entity.Admin" scope="request"/>

<div id="main-content" class="container">

    <ol class="breadcrumb">
        <li class="active">系统管理</li>
        <li><a href="${ctx}/admin/selfupdate">个人信息</a></li>
    </ol>

    <c:if test="${not empty message}">
        <div id="message" class="alert alert-success">${message}</div>
    </c:if>

    <form id="form" action="${ctx}/admin/selfupdate" method="post" class="form-horizontal content" role="form">
        <input type="hidden" name="id" value="${admin.id}"/>
        <input type="hidden" name="name" value="${admin.name}"/>
        <input type="hidden" name="roleId" value="${admin.role.id}"/>
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
            <label class="control-label col-sm-3" for="password">密码</label>
            <div class="col-sm-4">
                <input type="password" id="password" name="password" maxlength="20" class="form-control" rel="popover" data-content="请至少使用 6 个字符。不填则保持不变。"/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3" for="pwdCfm">确认密码</label>
            <div class="col-sm-4">
                <input type="password" id="pwdCfm" name="pwdCfm" maxlength="20" class="form-control" rel="popover" data-content="请再次输入密码。"/>
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
                <p class="form-control-static"><%=getStateText(admin.getState())%></p>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3">角色<strong>*</strong></label>
            <div class="col-sm-4">
                <p class="form-control-static">${admin.role.name}</p>
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
                        password:
                        {
                            minlength: 6,
                            maxlength: 15
                        },
                        pwdCfm:
                        {
                            minlength: 6,
                            maxlength: 15,
                            equalTo: '#password'
                        },
                        email:  { email: true }
                    },
                    messages:
                    {
                        password:
                        {
                            minlength: '至少包含 6 个字母或数字。',
                            maxlength: '密码长度不超过 15 个字符。'
                        },
                        pwdCfm:
                        {
                            minlength: '至少包含 6 个字母或数字。',
                            maxlength: '密码长度不超过 15 个字符。',
                            equalTo: '两次输入的密码不一致。'
                        },
                        email: { email: '请输入合法的电子邮箱地址。'}
                    }
                });
    });

</script>

<%@ include file="../inc/footer.inc.jsp" %>