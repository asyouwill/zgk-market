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
                <img src="<%=ctx%>/static/img/modify-user-detail/avatar.png" alt=""/>
            </div>
            <div class="upload-btn">上传头像</div>
        </div>
        <div class="form-group">
            <div class="label">姓名</div>
            <input type="text"/>
            <div class="clear">
                <img src="<%=ctx%>/static/img/modify-user-detail/clear.png" alt=""/>
            </div>
        </div>
    </form>
</div>
</body>
</html>