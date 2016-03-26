define(function (require, exports, module) {
    var $ = require('$');
    var utils = require('utils');
    require('bts');

    var UI = {
        $timeList: $('#timeList'),
        $addStatistics: $('#addStatistics')
    };
    var statisticsTips = '';
    if (UI.$timeList.val() == 0) {
        statisticsTips += '<p class="tips">请您根据学校实际情况添加/设置统计时间，如有问题，联系4006699580</p>'
    } else {
        statisticsTips += ''
    }
    // 添加打卡记录
    var statisticsTitle = '<div class="text-center" >添加打开记录</div>'
    var statisticsHtml = ''
        + '<div class="text-center statisticsHtml" id="statisticsHtml" dataId="">'
        + statisticsTips
        + '<div class="alert alert-danger" role="alert">...</div>'
        + '<form class="form-horizontal">'
        + '<div class="form-group">'
        + '<label for="inputName" class="col-sm-2 control-label">图表名称:</label>'
        + '<div class="col-sm-10">'
        + '<input type="text" class="form-control statisticsName" id="inputName" placeholder="默认统计情况">'
        + '</div>'
        + '</div>'
        + '<div class="form-group" id="intoSchool">'
        + '<label for="intoSchool" class="col-sm-2 control-label">进校时间:</label>'
        + '<div class="col-sm-10">'
        + '<span class="hourTxt">    '
        + '<input type="text" name="startHour" value="0" id="hourInputA" class="form-control w-input hour"/>'
        + '<span class="txt"> 时</span>  '
        + '<span class="arrow-up"></span> '
        + '<span class="arrow-down"></span>'
        + '</span>'
        + '<span class="minuteTxt">  '
        + '<input type="text" name="startMinute" value="0" id="minuteInputA" class="form-control w-input minute"/>'
        + '<span class="txt"> 分</span> '
        + '<span class="arrow-up"></span>'
        + '<span class="arrow-down"></span>'
        + '</span>'
        + '</div>'
        + '</div>'
        + '<div class="form-group" id="outSchool">'
        + '<label for="outSchool" class="col-sm-2 control-label">离校时间:</label>'
        + '<div class="col-sm-10">'
        + '<span class="hourTxt">    '
        + '<input type="text" name="startHour" value="0" id="hourInputB" class="form-control w-input hour"/>'
        + '<span class="txt"> 时</span>  '
        + '<span class="arrow-up"></span> '
        + '<span class="arrow-down"></span>'
        + '</span>'
        + '<span class="minuteTxt">  '
        + '<input type="text" name="startMinute" value="0" id="minuteInputB" class="form-control w-input minute"/>'
        + '<span class="txt"> 分</span> '
        + '<span class="arrow-up"></span>'
        + '<span class="arrow-down"></span>'
        + '</span>'
        + '</div>'
        + '</div>'
        + '<div class="form-group">'
        + '<div class="statistics-btns">'
        + '<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>'
        + '<button type="button" class="btn btn-primary" id="comfirmStatistics">确定</button>'
        + '</div>'
        + '</div>'
        + '</form>'
        + '</div>';
    if (UI.$timeList.val() == 0) {
        utils.modalTips(statisticsTitle, statisticsHtml);
        timeClickFn();
        var modalTipsFailTitle = '<div class="text-center">添加打开记录</div>';
        var modalTipsFailContent = '<div class="text-center">添加失败</div>';
        ComfirmStatistics(modalTipsFailTitle,modalTipsFailContent);
    }



    function timeClickFn(){
        // 进校时间
        $('#intoSchool .hourTxt .arrow-up').on('click', function () {
            InputUp($("#hourInputA"), 24);
            $('.statisticsHtml .alert').hide().text('');
        });
        $('#intoSchool .hourTxt .arrow-down').on('click', function () {
            InputDown($("#hourInputA"), 23)
            $('.statisticsHtml .alert').hide().text('');
        });
        $('#intoSchool .minuteTxt .arrow-up').on('click', function () {
            InputUp($("#minuteInputA"), 60);
        });
        $('#intoSchool .minuteTxt .arrow-down').on('click', function () {
            InputDown($("#minuteInputA"), 59)
        });

        // 离校时间
        $('#outSchool .hourTxt .arrow-up').on('click', function () {
            InputUp($("#hourInputB"), 24);
            $('.statisticsHtml .alert').hide().text('');
        });
        $('#outSchool .hourTxt .arrow-down').on('click', function () {
            InputDown($("#hourInputB"), 23)
            $('.statisticsHtml .alert').hide().text('');
        });
        $('#outSchool .minuteTxt .arrow-up').on('click', function () {
            InputUp($("#minuteInputB"), 60);
        });
        $('#outSchool .minuteTxt .arrow-down').on('click', function () {
            InputDown($("#minuteInputB"), 59)
        });

        $('#hourInputA,#hourInputB').on('keydown', function (ev) {
            var oEvent = ev || event;
            if (oEvent.keyCode != 8 && oEvent.keyCode < 48 || oEvent.keyCode > 57) {
                return false;
            }
        });
        $('#minuteInputA,#minuteInputB').on('keydown', function (ev) {
            var oEvent = ev || event;
            if (oEvent.keyCode != 8 && oEvent.keyCode < 48 || oEvent.keyCode > 57) {
                return false;
            }
        });
        $('#statisticsHtml input[type="text"]').keyup(function () {
            if ($(this).val().trim() != "") {
                $('.statisticsHtml .alert').hide().text('');
            }
        });
    }


    function ComfirmStatistics(modalTipsFailTitle,modalTipsFailContent){
        // 确定添加图表
        $('#comfirmStatistics').on('click', function () {
            var _this = $(this);
            var schoolIdVal = $('#schoolId').val();
            var periodNameVal = _this.parents('.modal-body').find('.statisticsName').val();
            //console.log('periodNameVal----' + periodNameVal.trim());
            if (periodNameVal.trim() == "") {
                $('.statisticsHtml .alert').show().text('图表名称不能为空！');
                return false;
            }

            // 进校小时
            if ($('#hourInputA').val().trim() == "") {
                $('.statisticsHtml .alert').show().text('进校时间小时不能为空！');
                return false;
            }
            if ($('#hourInputA').val() > 23) {
                $('.statisticsHtml .alert').show().text('进校时间小时在0~23之间！');
                return false;
            }

            // 进校分钟
            if ($('#minuteInputA').val().trim() == "") {
                $('.statisticsHtml .alert').show().text('进校时间分钟不能为空！');
                return false;
            }
            if ($('#minuteInputA').val() > 59) {
                $('.statisticsHtml .alert').show().text('进校时间分钟在0~59之间！');
                return false;
            }

            // 离校小时
            if ($('#hourInputB').val().trim() == "") {
                $('.statisticsHtml .alert').show().text('离校时间小时不能为空！');
                return false;
            }
            if ($('#hourInputB').val().trim() > 23) {
                $('.statisticsHtml .alert').show().text('离校时间小时在0~23之间！');
                return false;
            }

            // 离校分钟
            if ($('#minuteInputB').val().trim() == "") {
                $('.statisticsHtml .alert').show().text('离校时间分钟不能为空！');
                return false;
            }
            if ($('#minuteInputB').val().trim() > 59) {
                $('.statisticsHtml .alert').show().text('离校时间分钟在0~59之间！');
                return false;
            }

            // 获取进校时间
            var hourInputANum = parseInt($('#hourInputA').val());
            if (hourInputANum < 10) {
                hourInputANum = "0" + hourInputANum;
            }

            var minuteInputANum = parseInt($('#minuteInputA').val());
            if (minuteInputANum < 10) {
                minuteInputANum = "0" + minuteInputANum;
            }


            var startTime = hourInputANum + ":" + minuteInputANum;
            // 获取离校时间
            var hourInputBNum = parseInt($('#hourInputB').val());
            if (hourInputBNum < 10) {
                hourInputBNum = "0" + hourInputBNum;
            }

            var minuteInputBNum = parseInt($('#minuteInputB').val());
            if (minuteInputBNum < 10) {
                minuteInputBNum = "0" + minuteInputBNum;
            }
            var endTime = hourInputBNum + ":" + minuteInputBNum;
            var periodId = $('#statisticsHtml').attr('dataId');

            $.ajax({
                type: 'POST',
                url: rootPath + '/web/addPeriod',
                data: {
                    schoolId: schoolIdVal,
                    startTime: startTime,
                    endTime: endTime,
                    periodName: periodNameVal,
                    periodId: periodId
                },
                success: function (result) {
                    if (result.bizData == "success") {
                        window.location.href = rootPath + '/web/index';
                    } else if (result.bizData == "fail") {
                        utils.modalTips(modalTipsFailTitle,modalTipsFailContent);
                    }
                }
            })
        })
    }

    // 添加btn统计图表
    UI.$addStatistics.on('click', function () {
        utils.modalTips(statisticsTitle, statisticsHtml);
        timeClickFn();
        var modalTipsFailTitle = '<div class="text-center">添加打开记录</div>';
        var modalTipsFailContent = '<div class="text-center">添加失败</div>';
        ComfirmStatistics(modalTipsFailTitle,modalTipsFailContent);
    });

    function InputUp(obj, num) {
        var minNum = obj.val();
        minNum++;
        obj.val(minNum);
        if (obj.val() == num || obj.val() == "") {
            obj.val("0");
        }
    }

    function InputDown(obj, num) {
        var maxNum = obj.val();
        maxNum--;
        obj.val(maxNum);
        if (obj.val() == "-1" || obj.val() == "") {
            obj.val(num);
        }
    }


    // 修改
    $('.statistics-box').on('click', '#updateStatistics', function () {
        var periodId = $(this).parents('.statistics-list').attr('id');
        console.log(periodId)
        var statisticsUpdateTitle = '<div class="text-center" dataId="' + timeTableId + '">修改打开记录</div>'
        utils.modalTips(statisticsUpdateTitle, statisticsHtml);
        $('#statisticsHtml').attr('dataId',periodId);
        //console.log($('#statisticsHtml').attr('dataId'))
        $.ajax({
            type: 'POST',
            url: rootPath + '/web/getPeriod',
            data: {
                periodId: periodId
            },
            success: function (result) {
                if (result.bizData) {
                    var resultData = JSON.parse(result.bizData),
                        periodName = resultData.periodName,
                        hourInputA = parseInt(resultData.startTime.substring(0, 2)),
                        minuteInputA = parseInt(resultData.startTime.substring(3, 5)),
                        hourInputB = parseInt(resultData.endTime.substring(0, 2)),
                        minuteInputB = parseInt(resultData.endTime.substring(3, 5));
                    // 标题赋值
                    $('#inputName').val(periodName);
                    // 进校小时
                    $('#hourInputA').val(hourInputA);
                    // 进校分钟
                    $('#minuteInputA').val(parseInt(minuteInputA));
                    // 离校小时
                    $('#hourInputB').val(hourInputB);
                    // 离校分钟
                    $('#minuteInputB').val(minuteInputB);
                    timeClickFn();
                    var modalTipsFailTitle = '<div class="text-center">添加打开记录</div>';
                    var modalTipsFailContent = '<div class="text-center">添加失败</div>';
                    ComfirmStatistics(modalTipsFailTitle,modalTipsFailContent);
                } else if (result.bizData == "fail") {

                }
            }
        })
    });

    // 删除
    $('.statistics-box').on('click', '#delStatistics', function () {
        var periodId = $(this).parents('.statistics-list').attr('id');
        var delTitle = '<div class="text-center">删除打开记录</div>';
        var delContent = ''
            + '<div class="text-center delModalBody">确认删除这条记录吗？</div>'
            + '<div class="form-group">'
            + '<div class="statistics-btns">'
            + '<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>'
            + '<button type="button" class="btn btn-primary" id="delConfirmStatistics">确定</button>'
            + '</div>'
            + '</div>'
            + '</div>';
        utils.modalTips(delTitle, delContent);
        $('#delConfirmStatistics').on('click', function () {
            $.ajax({
                type: 'POST',
                url: rootPath + '/web/delPeriod',
                data: {
                    periodId: periodId
                },
                success: function (result) {
                    if (result.bizData == "success") {
                        window.location.href = rootPath + '/web/index';
                    } else if (result.bizData == "fail") {
                        utils.modalTips('<div class="text-center">删除打开记录</div>', '<div class="text-center">删除失败</div>');
                    }
                }
            })
        })
    })


});
