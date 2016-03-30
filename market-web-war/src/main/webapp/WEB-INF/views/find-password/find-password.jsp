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
    <form id="register" action="">
        <div class="form-group">
            <div class="input-group">
                <i class="mobile-icon"></i>
                <input type="text" placeholder="请输入手机号码"/>
            </div>
        </div>
        <div class="form-group">
            <input class="check-code" type="text" placeholder="输入验证码"/>
            <input type="button" value="获取验证码" />
        </div>
        <div class="form-group">
            <div class="input-group">
                <i class="password-icon"></i>
                <input type="password" placeholder="密码"/>
            </div>
        </div>
        <div class="form-group">
            <div class="input-group">
                <i class="password-icon"></i>
                <input type="password" placeholder="确认密码"/>
            </div>
        </div>
        <div class="form-group">
            <button class="submit-btn">确认</button>
        </div>
    </form>
</div>
</body>
</html>