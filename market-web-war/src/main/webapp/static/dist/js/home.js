define(function (require, exports, module) {
    var $ = require('$');
    var utils = require('utils');
    require('bts');

    var UI = {
        $timeList: $('#timeList')
    };
    if (UI.$timeList.val() == "") {
        var timeListTitle = '<div class="text-center">温馨提示</div>'
        var timeListHtml = '<div class="text-center timeListContent">请您根据学校实际情况添加/设置统计时间，如有问题，联系4006699580</div>'
        utils.modalTips(timeListTitle, timeListHtml);
    }
    // 添加打卡记录
    var statisticsTitle = '<div class="text-center">添加打开记录</div>'
    var statisticsHtml = ''
        + '<div class="text-center statisticsHtml">'
        + '<form class="form-horizontal">'
        + '<div class="form-group">'
        + '<label for="inputName" class="col-sm-2 control-label">图标名称</label>'
        + '<div class="col-sm-10">'
        + '<input type="text" class="form-control" id="inputName" placeholder="默认统计情况">'
        + '</div>'
        + '</div>'
        + '<div class="form-group">'
        + '<label for="intoSchool" class="col-sm-2 control-label">进校时间</label>'
        + '<div class="col-sm-10">'
        + '<span class="hourTxt">    '
        + '<input type="text" name="startHour" value="0" id="hourInputA" class="w-input hour"/>'
        + '<span class="txt"> 时</span>  '
        + '<span class="arrow-up"></span> '
        + '<span class="arrow-down"></span>'
        + '</span>'
        + '<span class="minuteTxt">  '
        + '<input type="text" name="startMinute" value="0" id="minuteInputA" class="w-input minute"/>'
        + '<span class="txt"> 分</span> '
        + '<span class="arrow-up"></span>'
        + '<span class="arrow-down"></span>'
        + '</span>'
        + '</div>'
        + '</div>'
        + '<div class="form-group">'
        + '<label for="outSchool" class="col-sm-2 control-label">离校时间</label>'
        + '<div class="col-sm-10">'
        + '<span class="hourTxt">    '
        + '<input type="text" name="startHour" value="0" id="hourInputA" class="w-input hour"/>'
        + '<span class="txt">时</span>  '
        + '<span class="arrow-up"></span> '
        + '<span class="arrow-down"></span>'
        + '</span>'
        + '<span class="minuteTxt">  '
        + '<input type="text" name="startMinute" value="0" id="minuteInputA" class="w-input minute"/>'
        + '<span class="txt">分</span> '
        + '<span class="arrow-up"></span>'
        + '<span class="arrow-down"></span>'
        + '</span>'
        + '</div>'
        + '</div>'
        + '<div class="form-group">'
        + '<div class="col-sm-offset-2 col-sm-10">'
        + '<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>'
        + '<button type="button" class="btn btn-primary">确定</button>'
        + '</div>'
        + '</div>'
        + '</form>'
        + '</div>';
    utils.modalTips(statisticsTitle, statisticsHtml);


});
