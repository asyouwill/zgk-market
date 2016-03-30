<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <%@ include file="../common/meta.jsp"%>
    <title>登录页</title>
    <link rel="stylesheet" href="<%=ctx%>/static/dist/css/user-detail/style.css"/>
</head>
<body>
<%@ include file="../common/header.jsp"%>
<div class="container">
    <div class="user-info">
        <span class="modify-btn">
            修改
        </span>
        <div class="info-center">
            <div><img src="<%=ctx%>/static/img/user-detail/avatar.png" alt=""/></div>
            <div class="name">邓飞</div>
            <div class="account">账号：15209209248</div>
        </div>
    </div>
    <div class="user-detail">
        <ul class="detail-list">
            <li>
                <span>性别</span>
                <span>女</span>
            </li>
            <li>
                <span>所在省份：</span>
                <span>陕西</span>
            </li>
            <li>
                <span>所在县区：</span>
                <span>山阳县</span>
            </li>
            <li>
                <span>所在中学：</span>
                <span>山阳中学</span>
            </li>
            <li>
                <span>科目：</span>
                <span>理科</span>
            </li>
            <li>
                <span>Email：</span>
                <span>256361212@qq.com</span>
            </li>
            <li>
                <span>我的二维码：</span>
                <span>
                    <img src="<%=ctx%>/static/img/user-detail/code.png" alt=""/>
                </span>
            </li>
        </ul>
    </div>
    <div class="change-password-btn">
        修改密码
    </div>
</div>
</body>
</html>