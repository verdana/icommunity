<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="../inc/header.inc.jsp"%>

<div id="main-content" class="container">

    <ol class="breadcrumb">
        <li class="active">系统管理</li>
        <li><a href="${ctx}/admin">管理员管理</a></li>
        <li class="active">创建</li>
    </ol>

    <form id="form" action="${ctx}/admin/create" method="post" class="form-horizontal content" role="form">
        <div class="form-group">
            <label class="control-label col-sm-3" for="name">帐号<strong>*</strong></label>
            <div class="col-sm-4">
                <input type="text" id="name" name="name" class="form-control" maxlength="63" rel="popover" data-content="您可以使用字母 (a-z)、数字和英文句点。"/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3" for="trueName">真实姓名</label>
            <div class="col-sm-4">
                <input type="text" id="trueName" name="trueName" class="form-control" maxlength="63"/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3" for="password">密码<strong>*</strong></label>
            <div class="col-sm-4">
                <input type="password" id="password" name="password" class="form-control" maxlength="20" rel="popover" data-content="请至少使用 6 个字符。请勿使用您用于登录其他网站的密码或容易被猜到的密码。"/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3" for="password">确认密码<strong>*</strong></label>
            <div class="col-sm-4">
                <input type="password" id="pwdCfm" name="pwdCfm" class="form-control" maxlength="20" rel="popover" data-content="请再次输入密码。"/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3" for="phone">电话号码</label>
            <div class="col-sm-4">
                <input type="text" id="phone" name="phone" class="form-control" maxlength="20"/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3" for="mobile">手机</label>
            <div class="col-sm-4">
                <input type="text" id="mobile" name="mobile" class="form-control" maxlength="20"/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3" for="email">电子邮箱</label>
            <div class="col-sm-4">
                <input type="text" id="email" name="email" type="email" class="form-control" maxlength="127" rel="popover" data-content="请输入如 username@domain.ext 格式。"/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3">状态</label>
            <div class="col-sm-4">
                <html:select id="state" name="state" options="<%=Stateful.TEXT%>" classname="form-control" hasBlankOption="false" hasNaOption="false"/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3" for="roleId">角色<strong>*</strong></label>
            <div class="col-sm-4">
                <select id="roleId" name="roleId" class="form-control">
                    <c:forEach items="${roles}" var="role">
                        <option value="${role.id}">${role.name}</option>
                    </c:forEach>
                </select>
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
                name: { required: true, pattern: '^[a-z0-9.]+$' },
                password:  { required: true, minlength: 6, maxlength: 20 },
                pwdCfm: { required: true, equalTo: '#password' },
                email: { email: true }
            },
            messages:
            {
                name: { required: '此处不能留空。', pattern: '请勿使用除字母 (a-z)、数字和英文句号外的其他字符。' },
                password: { required: '此处不能留空。', minlength: '过短的密码很容易被猜到。请尝试使用至少包含 6 个字符的密码。', maxlength: '密码长度不超过 20 个字符。' },
                pwdCfm: { required: '此处不能留空。', equalTo: '两个密码不匹配。是否重试？' },
                email: { email: "输入内容不是一个合法格式的电子邮件地址。" }
            }
        });
    });

</script>

<%@ include file="../inc/footer.inc.jsp" %>