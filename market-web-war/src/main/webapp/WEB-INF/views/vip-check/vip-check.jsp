<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <%@ include file="../common/meta.jsp"%>
    <title>登录页</title>
    <link rel="stylesheet" href="<%=ctx%>/static/dist/css/vip-check/style.css"/>
</head>
<body>
<%@ include file="../common/header.jsp"%>
<div class="container">
    <div class="banner">
        <img src="<%=ctx%>/static/img/vip/banner.png" alt=""/>
    </div>
    <div class="vip-check-info">
        <img src="<%=ctx%>/static/img/vip-check/vip.png" alt=""/>
        <div class="text">
            <div>您已VIP是会员</div>
            <div>VIP时效：从2016-02-25到2019-09-01</div>
        </div>
    </div>
</div>
</body>
</html>