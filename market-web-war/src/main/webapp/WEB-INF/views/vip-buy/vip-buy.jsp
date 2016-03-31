<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <%@ include file="../common/meta.jsp"%>
    <title>登录页</title>
    <link rel="stylesheet" href="<%=ctx%>/static/dist/css/vip-buy/style.css"/>
</head>
<body>
<%@ include file="../common/header.jsp"%>
<div class="container">
    <div class="description">
        <div class="title">只能高考VIP服务卡</div>
        <div class="content">
            升级成为VIP后，可免费观看高考学堂全部视频；进行权威职业测评服务；在线浏览数据库资料，全国各大高等院校专业资料；提前熟悉志愿填报流程，享受智能推荐填报志愿服务。
        </div>
    </div>
    <div class="vip-check-info">
        <img src="<%=ctx%>/static/dist/img/icons/vip.png" alt=""/>
        <div class="text">
            <div>价格：511元</div>
        </div>
    </div>
    <div class="vip-buy-btn">
        立即购买
    </div>
    <div class="modal hidden">
        <div class="order-info">
            <div>订单ID：20160317133727345</div>
            <div>购买服务名称：VIP系统服务</div>
            <div>服务价格：511元</div>
            <div>应付费用：511元</div>
        </div>
        <div class="confirm-btn">确认支付</div>
    </div>
</div>
<script src="<%=ctx%>/static/dist/js/vip.js"></script>
</body>
</html>