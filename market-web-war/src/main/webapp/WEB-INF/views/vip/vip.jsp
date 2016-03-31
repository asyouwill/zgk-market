<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <%@ include file="../common/meta.jsp"%>
    <title>登录页</title>
    <link rel="stylesheet" href="<%=ctx%>/static/dist/css//vip/style.css"/>
</head>
<body>
<%@ include file="../common/header.jsp"%>
<div class="container">
    <div class="banner">
        <img src="<%=ctx%>static/dist/img/icons/banner.png" alt=""/>
    </div>
    <form action="">
        <div class="form-group">
            <div class="input-group">
                <i class="mobile-icon"></i>
                <input type="text" placeholder="充值账号：15209209240">
            </div>
        </div>
        <div class="form-group">
            <div class="input-group">
                <i class="card-icon"></i>
                <input type="text" placeholder="卡号：">
            </div>
        </div>
        <div class="form-group">
            <div class="input-group">
                <i class="password-icon"></i>
                <input type="password" placeholder="密码：">
            </div>
        </div>
        <div class="vip-btn">
            升级vip
        </div>
        <div class="link">
            <a href="">在线购买VIP特权</a>
        </div>
    </form>
</div>
<script type="text/javascript" src=""></script>
</body>
</html>