<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <%@ include file="../common/meta.jsp"%>
    <title>登录页</title>
    <link rel="stylesheet" href="<%=ctx%>/static/dist/css/modify-user-detail/style.css"/>
</head>
<body>
<%@ include file="../common/header.jsp"%>
<div class="container">
    <form action="">
        <div class="avatar">
            <div>
                <img src="../../../img/modify-user-detail/avatar.png" alt=""/>
            </div>
            <div class="upload-btn">上传头像</div>
        </div>
        <div class="form-group">
            <div class="label">姓名</div>
            <input type="text"/>
            <div class="clear">
                <img src="../../../img/modify-user-detail/clear.png" alt=""/>
            </div>
        </div>
        <div class="form-group">
            <div class="label">性别选择：</div>
            <div class="options right">
                <span class="active">女</span>
                <span>男</span>
            </div>
        </div>
        <div class="form-group">
            <div class="label">所在中学：</div>
            <input type="text"/>
            <div class="clear">
                <img src="../../../img/modify-user-detail/clear.png" alt=""/>
            </div>
        </div>
        <div class="form-group">
            <div class="label">科目选择：</div>
            <div class="options right">
                <span>文科</span>
                <span class="active">理科</span>
            </div>
        </div>
        <div class="form-group">
            <div class="label">Email</div>
            <input type="text"/>
            <div class="clear">
                <img src="../../../img/modify-user-detail/clear.png" alt=""/>
            </div>
        </div>
        <div class="submit-btn">
            提交
        </div>
    </form>
</div>
</body>
</html>