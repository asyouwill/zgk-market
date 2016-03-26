<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<c:set var="jsPath" value="${pageContext.request.contextPath}/javascripts"/>
<c:set var="cssPath" value="${pageContext.request.contextPath}/themes/css"/>
<c:set var="imgPath" value="${pageContext.request.contextPath}/themes/images"/>
<c:set var="timestamp" value="<%=System.currentTimeMillis()%>" />
<c:set var="app" value="${pageContext.request.contextPath}/static/app"/>
<c:set var="dist" value="${pageContext.request.contextPath}/static/dist"/>

