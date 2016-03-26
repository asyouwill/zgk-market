<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="common/taglibs.jsp" %>
<html>
<head>
    <title>首页</title>
    <%@ include file="common/meta.jsp" %>
</head>
<body>
<%@ include file="common/top.jsp" %>
<input name="" type="hidden" value="${pageList.getCount()}" id="classRecordPageCount" />
<input name="" type="hidden" value="${pageList.getPageSize()}" id="classRecordPageSize" />
<input name="" type="hidden" value="${classId}" id="classId" />
<input name="" type="hidden" value="${dateTime}" id="dateTime" />
<input name="" type="hidden" value="${callingType}" id="callingType" />
<input name="" type="hidden" value="${studentName}" id="studentName" />
<input name="" type="hidden" value="${pageNo}" id="pageNo" />
<div class="container-wrap">
    <div class="search-box" id="user-form">
        <form class="form-inline" action="${ctx}/web/user">
            <div class="form-group">
                <label class="sr-label">班级</label>
                <select class="form-control" name="classId">
                    <option value="">请选择班级</option>
                    <c:forEach items="${classList}" var="clazz" >
                        <option value="${clazz.classId}" <c:if test="${clazz.classId eq classId}">selected="selected" </c:if>>${clazz.className}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label class="sr-label">日期</label>
                <input type="text" class="form-control" id="datepicker" placeholder="请选择日期" name = "dateTime" value="${dateTime}">
            </div>
            <div class="form-group">
                <label class="sr-label">类型</label>
                <select  class="form-control" name="callingType">
                    <option value="">请选择类型</option>
                    <option value="0" <c:if test="${callingType eq '0'}">selected="selected" </c:if>>入校</option>
                    <option value="1" <c:if test="${callingType eq '1'}">selected="selected" </c:if>>离校</option>

                </select>
            </div>
            <div class="form-group">
                <input type="text" name="studentName" placeholder="输入学生姓名" class="form-control" id="" value="${studentName}"/>
            </div>
            <button type="submit" class="btn btn-default">查询</button>
        </form>
    </div>
    <div class="search-list">
        <div class="table-box">
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th width="5%">序号</th>
                    <th width="20%">姓名</th>
                    <th width="20%">班级</th>
                    <th width="35%">打卡时间</th>
                    <th width="20%">结果</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${pageList.getList()}" var="record" begin="0" step="1" varStatus="status">
                    <tr>
                        <td>${status.count}</td>
                        <td>${record.studentName}</td>
                        <td>${record.className}</td>
                        <td>${record.callingTime}</td>
                        <td>${record.callingResult}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="text-center">
            <div id="pagers"></div>
        </div>
        <div class="tips-info">
            <p>迟到：进校打卡时间见晚于到校设定时间，记为迟到 </br>
                早退：离校打卡时间见早于离校设定时间，记为早退</p>
        </div>
    </div>
</div>
<script>
    seajs.use("${ctx}/static/app/js/user.js");
</script>
</body>
</html>
