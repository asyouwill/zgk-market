<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <%@ include file="../common/meta.jsp"%>
    <title>登录页</title>
    <link rel="stylesheet" href="<%=ctx%>/static/dist/css/order/style.css"/>
</head>
<body>
<%@ include file="../common/header.jsp"%>
<div class="container">
    <div class="order-list">
        <div class="order-item">
            <img class="img-paid" src="<%=ctx%>/static/img/order/paid.png" alt=""/>
            <ul class="item-list">
                <li>
                    <span>智高考VIP服务</span>
                    <span>￥802.02元</span>
                    <span>已支付</span>
                </li>
                <li>
                    <span>成交时间：2016/03/17</span>
                    <span>14:23</span>
                </li>
                <li>
                    <span>取货地址：陕西省西安市新城区</span>
                </li>
                <li>
                    <span>取货电话：18637372819</span>
                </li>
            </ul>
        </div>
        <div class="order-item unpaid">
            <ul class="item-list">
                <li>
                    <span>智高考VIP服务</span>
                    <span>￥802.02元</span>
                    <span>去支付</span>
                </li>
                <li>
                    <span>成交时间：2016/03/17</span>
                    <span>14:23</span>
                </li>
                <li>
                    <span>取货地址：陕西省西安市新城区</span>
                </li>
                <li>
                    <span>取货电话：18637372819</span>
                </li>
            </ul>
        </div>
        <div class="order-item unpaid">
            <ul class="item-list">
                <li>
                    <span>智高考VIP服务</span>
                    <span>￥802.02元</span>
                    <span>去支付</span>
                </li>
                <li>
                    <span>成交时间：2016/03/17</span>
                    <span>14:23</span>
                </li>
                <li>
                    <span>取货地址：陕西省西安市新城区</span>
                </li>
                <li>
                    <span>取货电话：18637372819</span>
                </li>
            </ul>
        </div>
    </div>
</div>
</body>
</html>