<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <%@ include file="../common/meta.jsp"%>
    <title>登录页</title>
    <link rel="stylesheet" href="<%=ctx%>/static/dist/css/code/style.css"/>
</head>
<body>
<%@ include file="../common/header.jsp"%>
<div class="container">
    <div class="user-info clearfix">
        <div class="avatar left">
            <img src="<%=ctx%>/static/img/code/avatar.png"/>
        </div>
        <div class="summary left">
            <div class="name">邓平</div>
            <div class="account">账号：15209209284</div>
        </div>
    </div>
    <div class="code">
        <img src="<%=ctx%>/static/img/code/code.png" alt=""/>
    </div>
    <div class="share-btn">
        分享二维码
    </div>
</div>
<script src="<%=ctx%>/static/dist/js/code.js"></script>
</body>
</html>