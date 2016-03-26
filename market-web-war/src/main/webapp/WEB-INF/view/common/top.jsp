<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--头部-->
<div class="container-fluid" id="common-header">
    <div class="container-wrap">
        <h1 id="common-logo">校园卫士</h1>
        <ul class="header-nav" id="header-nav-tab">
            <c:choose>
                <c:when test="${page=='home'}">
                    <li class="active"><a href="${ctx}/web/index">学校</a></li>
                    <li><a href="${ctx}/web/class">班级</a></li>
                    <li><a href="${ctx}/web/user">个人</a></li>
                </c:when>
                <c:when test="${page=='class'}">
                    <li><a href="${ctx}/web/index">学校</a></li>
                    <li class="active"><a href="${ctx}/web/class">班级</a></li>
                    <li><a href="${ctx}/web/user">个人</a></li>
                </c:when>
                <c:when test="${page=='user'}">
                    <li><a href="${ctx}/web/index">学校</a></li>
                    <li><a href="${ctx}/web/class">班级</a></li>
                    <li class="active"><a href="${ctx}/web/user">个人</a></li>
                </c:when>
            </c:choose>
        </ul>
        <dl class="login-status" id="loginToggleBox">
            <dt>
                <c:choose>
                    <c:when test="${empty sessionScope.user.userIcon}">
                        <img class="user-img" src="${ctx}/static/dist/images/login-header-bg.png" alt=""/>
                    </c:when>
                    <c:otherwise>
                        <img class="user-img" src="${sessionScope.user.userIcon}" alt="用户头像"/>
                    </c:otherwise>
                </c:choose>
            </dt>
            <dd>
                <h3 class="name">${sessionScope.user.userName}</h3>
            </dd>
            <ul class="login-end-menu" id="loginToggleFun">
                <li><a href="${ctx}/web/login/loginOut">退出</a></li>
            </ul>
        </dl>
    </div>
</div>
<div class="header-bg"></div>
<script>
    seajs.use("${ctx}/static/app/js/top");
</script>

