<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="common/taglibs.jsp" %>
<html>
<head>
    <title>首页</title>
    <%@ include file="common/meta.jsp" %>
</head>
<body>
<%@ include file="common/top.jsp" %>
<script>
    seajs.use("${ctx}/static/app/js/home.js?t=${timestamp}");
</script>
<script src="${ctx}/static/bower_components/jquery/dist/jquery.min.js"></script>
<script src="${ctx}/static/bower_components/echarts/echarts-all.js"></script>
<input name="" value="${timeList.size()}" id="timeList" type="hidden"/>
<input name="" value="${sessionScope.role.xxjbxxId}" id="schoolId" type="hidden"/>
<div class="container-wrap">
    <div class="crumb">
        <span class="fl">当日打卡情况</span>
        <span class="fr"><a href="javascript:;" id="addStatistics">添加</a></span>
    </div>
    <div class="statistics-box">
        <c:forEach items="${periodCallingList}" var="item">
            <script>
                var timeTableId =  'timeTableId' + '${item.timeTable.id}' + 'A';
            </script>
            <div class="statistics-list" id="${item.timeTable.id}">
                <div class="statistics-title">
                    ${item.timeTable.periodName}(${item.timeTable.startTime}--${item.timeTable.endTime})<span class="fr"><a href="javascript:;" id="updateStatistics">修改</a><a
                        href="javascript:;" id="delStatistics">删除</a></span>
                </div>
                <div class="statistics-content">
                    <div class="fl">
                        <div id="echarts${item.timeTable.id}A" data="timeTableA"  style="width:486px;height:580px;"></div>
                        <script>
                            var  normalNumA = '${item.inCallingNum.normalNum}';
                            var  lateNumA = '${item.inCallingNum.lateNum}';
                            var  unscanningNumA = '${item.inCallingNum.unscanningNum}';
                            if(normalNumA == "" || normalNumA ==null){
                                normalNumA = 100;
                            }
                            if(lateNumA == "" || lateNumA ==null){
                                lateNumA = 100;
                            }
                            if(unscanningNumA == "" || unscanningNumA ==null){
                                unscanningNumA = 100;
                            }

                            //判断选项的值是否只有一个有，决定文字距离中心的位置
                            var num = 0;
                            if (parseInt(normalNumA) > 0) {
                                num++;
                            }
                            if (parseInt(lateNumA) > 0) {
                                num++;
                            }
                            if (parseInt(unscanningNumA) > 0) {
                                num++;
                            }
                            var distance = 0.5;
                            if (num == 1) {
                                distance = 0.01;
                            }
                            
                            var statisticsA1Chart = echarts.init(document.getElementById('echarts${item.timeTable.id}A'));
                            var statisticsA1option = {
                                title: {
                                    text: '进校情况',
                                    subtext: '',
                                    x: 'center',
                                    y: '70'
                                },
                                tooltip: {
                                    trigger: 'item',
                                    formatter: "{a} <br/>{b} : {c} ({d}%)"
                                },
                                legend: {
                                    selectedMode:false,
                                    orient: 'vertical',
                                    x: 50,
                                    y: 100,
                                    data: ['正常打卡人数', '迟到人数', '其他']
                                },
                                toolbox: {
                                    show: false
                                },
                                series: [
                                    {
                                        name: '打卡统计',
                                        type: 'pie',
                                        radius: '60%',
                                        center: ['50%', '60%'],
                                        itemStyle: {
                                            normal: {
                                                label: {
                                                    position: 'inner',
                                                    distance:distance,
                                                    formatter: function (params) {
                                                        if (!parseInt(params.value)) {
                                                            return;
                                                        }
                                                        return (params.percent - 0).toFixed(0) + '%'
                                                    },
                                                    textStyle: {
                                                        fontSize: '23'
                                                    }
                                                },
                                                labelLine: {
                                                    show: false
                                                }
                                            },
                                            emphasis: {
                                                label: {
                                                    show: true,
                                                    distance:distance,
                                                    formatter: "{b}\n{c}",
                                                    textStyle: {
                                                        fontSize: '20'
                                                    }
                                                }
                                            }

                                        },
                                        data: [
                                            {value: normalNumA, name: '正常打卡人数'},
                                            {value: lateNumA, name: '迟到人数'},
                                            {value: unscanningNumA, name: '其他'}
                                        ]
                                    }
                                ]
                            };
                            statisticsA1Chart.setOption(statisticsA1option);
                        </script>
                    </div>
                    <div class="fr">
                        <div id="B${item.timeTable.id}" style="width:486px;height:606px;"></div>
                        <script>
                            var normalNumB = '${item.outCallingNum.normalNum}';
                            var earlyNumB = '${item.outCallingNum.earlyNum}';
                            var unscanningNumB = '${item.outCallingNum.unscanningNum}';
                            if(normalNumB == "" || normalNumB ==null){
                                normalNumB = 100;
                            }
                            if(earlyNumB == "" || earlyNumB ==null){
                                earlyNumB = 100;
                            }
                            if(unscanningNumB == "" || unscanningNumB ==null){
                                unscanningNumB = 100;
                            }
                            //判断选项的值是否只有一个有，决定文字距离中心的位置
                            var numB = 0;
                            if (parseInt(normalNumB) > 0) {
                                numB++;
                            }
                            if (parseInt(earlyNumB) > 0) {
                                numB++;
                            }
                            if (parseInt(unscanningNumB) > 0) {
                                numB++;
                            }
                            var distanceB = 0.5;
                            if (numB == 1) {
                                distanceB = 0.01;
                            }
                            var statisticsA2Chart = echarts.init(document.getElementById('B${item.timeTable.id}'));
                            var statisticsA2option = {
                                title: {
                                    text: '离校情况',
                                    subtext: '',
                                    x: 'center',
                                    y: '70'
                                },
                                tooltip: {
                                    trigger: 'item',
                                    formatter: "{a} <br/>{b} : {c} ({d}%)"
                                },
                                legend: {
                                    selectedMode:false,
                                    orient: 'vertical',
                                    x: 50,
                                    y: 100,
                                    data: ['正常打卡人数', '早退人数', '其他']
                                },
                                toolbox: {
                                    show: false
                                },
                                series: [
                                    {
                                        name: '打卡统计',
                                        type: 'pie',
                                        radius: '60%',
                                        center: ['50%', '60%'],
                                        itemStyle: {
                                            normal: {
                                                label: {
                                                    position: 'inner',
                                                    distance:distanceB,
                                                    formatter: function (params) {
                                                        if (!parseInt(params.value)) {
                                                            return;
                                                        }
                                                        return (params.percent - 0).toFixed(0) + '%'
                                                    },
                                                    textStyle: {
                                                        fontSize: '20'
                                                    }
                                                },
                                                labelLine: {
                                                    show: false
                                                }
                                            },
                                            emphasis: {
                                                label: {
                                                    show: true,
                                                    distance:distanceB,
                                                    formatter: "{b}\n{c}",
                                                    textStyle: {
                                                        fontSize: '23'
                                                    }
                                                }
                                            }
                                        },
                                        data: [
                                            {value: normalNumB, name: '正常打卡人数'},
                                            {value: earlyNumB, name: '早退人数'},
                                            {value: unscanningNumB, name: '其他'}
                                        ]
                                    }
                                ]
                            };
                            statisticsA2Chart.setOption(statisticsA2option);
                        </script>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>


</body>
</html>
