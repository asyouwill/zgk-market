<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <%@ include file="../common/meta.jsp"%>
    <title>登录页</title>
    <link rel="stylesheet" href="<%=ctx%>/static/dist/css/register/style.css"/>
</head>
<body>
<%@ include file="../common/header.jsp"%>
<div class="container">
    <div class="tab-list">
        <div class="tab tab-login">登录</div>
        <div class="tab tab-register active">注册</div>
    </div>
    <form class="hidden" id="login" action="">
        <div class="form-group">
            <div class="input-group">
                <i class="mobile-icon"></i>
                <input type="text" placeholder="请输入手机号码"/>
            </div>
        </div>
        <div class="form-group">
            <div class="input-group">
                <i class="password-icon"></i>
                <input type="password" placeholder="请输入密码"/>
            </div>
        </div>
        <div class="reset-password">
            <a>忘记密码？</a>
        </div>
        <div class="form-group">
            <button class="submit-btn">登录</button>
        </div>
    </form>
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
            <div class="title">高考报名地区：</div>
            <div class="location-list">
                <div class="location-option-list"><span>省份</span></div>
                <div class="location-option-list"><span>市</span></div>
                <div class="location-option-list"><span>县</span></div>
            </div>
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
            <button class="submit-btn">注册</button>
        </div>
    </form>
</div>

<%--<script>--%>
    <%--$(function(){--%>
        <%--$('#header-title').text('注册');--%>
        <%--$('.tab-list .tab').on('click', function(){--%>
            <%--$('.tab-list .tab').removeClass('active');--%>
            <%--$(this).addClass('active');--%>
            <%--$('form').addClass('hidden');--%>
            <%--$('form').eq($(this).index()).removeClass('hidden');--%>
        <%--})--%>
    <%--})--%>
<%--</script>--%>
</body>
</html>