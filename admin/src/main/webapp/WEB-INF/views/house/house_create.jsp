<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="../inc/header.inc.jsp"%>

<div id="main-content" class="container">

    <ol class="breadcrumb">
        <li class="active">企业资源管理</li>
        <li><a href="${ctx}/house">户型管理</a></li>
        <li class="active">创建</li>
    </ol>

    <form id="form" action="${ctx}/house/create" method="post" class="form-horizontal content" role="form">
        <div class="form-group">
            <label class="control-label col-sm-3" for="name">户型<strong>*</strong></label>
            <div class="col-sm-4">
                <input type="text" id="name" name="name" class="form-control" maxlength="63" />
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3" for="area">面积<strong>*</strong></label>
            <div class="col-sm-4">
                <input type="text" id="area" name="area" class="form-control" maxlength="10" />
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3" for="price">价格<strong>*</strong></label>
            <div class="col-sm-4">
                <input type="text" id="price" name="price" class="form-control" maxlength="20"/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3" for="totalPrice">总价<strong>*</strong></label>
            <div class="col-sm-4">
                <input type="text" id="totalPrice" name="totalPrice" class="form-control" maxlength="20" readonly/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3" for="discount">折扣</label>
            <div class="col-sm-4">
                <input type="text" id="discount" name="discount"  class="form-control" maxlength="10"/>
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
            onkeyup: true,
            rules:
            {
                name: { required: true },
                area: { required: true },
                price: { required: true },
                totalPrice: { required: true }
            },
            messages:
            {
                name: { required: '此处不能留空。'},
                area: { required: '此处不能留空。'},
                price: { required: '此处不能留空。' },
                totalPrice: { required: '此处不能留空。' }
            }
        });

        $("#price").keyup(function(){
                  $("#totalPrice").val( $("#area").val() *  $("#price").val());
              });

    });


</script>

<%@ include file="../inc/footer.inc.jsp" %>