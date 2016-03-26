<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="common/taglibs.jsp" %>
<html>
<head>
    <title>登录</title>
    <%@ include file="common/meta.jsp" %>
</head>
<body>
<div class="container-fluid" id="login-page">
    <header class="login-header">名师面对面</header>
    <div class="container-wrap">
        <section id="login-body">
            <form method="post" id="video-login">
                <p class="bg-danger error-tips"></p>

                <div class="form-group">
                    <input type="text" class="form-control" id="userName" name="userName" placeholder="请输入您的用户名"
                           maxlength="11">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" id="pwd" name="pwd" placeholder="密码">
                </div>
                <button type="button" id="submit-btn" class="btn btn-default btn-block submit-btn">登录</button>
            </form>
        </section>
        <p class="tips">问题反馈:请发邮件至18091199363@189.cn</p>
    </div>
</div>
<script>
    seajs.use("${ctx}/static/app/js/login");
</script>
</body>
</html>
