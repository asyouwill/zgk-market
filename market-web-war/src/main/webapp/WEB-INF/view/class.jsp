<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ include file="common/taglibs.jsp" %>--%>
<html>
<head>
    <title>首页</title>
    <%@ include file="common/meta.jsp" %>
</head>
<body>
<%@ include file="common/top.jsp" %>
<input name="" type="hidden" value="${classRecordPage.getCount()}" id="classRecordPageCount" />
<input name="" type="hidden" value="${classRecordPage.getPageSize()}" id="classRecordPageSize" />
<input name="" type="hidden" value="${classId}" id="classId" />
<input name="" type="hidden" value="${dateTime}" id="dateTime" />
<input name="" type="hidden" value="${pageNo}" id="pageNo" />
<div class="container-wrap">
    <div class="search-box">
        <form class="form-inline">
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
                <input type="text" class="form-control" id="datepicker" placeholder="请选择日期" name="dateTime" value="${dateTime}">
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
                    <th width="25%">班级</th>
                    <th width="25%">日期</th>
                    <th width="15%">正常人次</th>
                    <th width="10%">迟到</th>
                    <th width="10%">早退</th>
                    <th width="10%">未打卡</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${classRecordPage.getList()}" var="classRecord" begin="0" step="1" varStatus="status">
                    <tr>
                        <td>${status.count}</td>
                        <td>${classRecord.className}</td>
                        <td>${classRecord.dateTime}</td>
                        <td>${classRecord.normalNum}</td>
                        <td>${classRecord.lateNum}</td>
                        <td>${classRecord.earlyNum}</td>
                        <td>${classRecord.unscanningNum}</td>
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
    seajs.use("${ctx}/static/app/js/class.js");
</script>
</body>
</html>
