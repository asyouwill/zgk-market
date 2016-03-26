define(function (require, exports, module) {
    var $ = require('$');
    require('bts');
    require('jqueryUi');
    require('paginator');
    $( "#datepicker" ).datepicker({
        numberOfMonths:1,//显示几个月
        showButtonPanel:false,//是否显示按钮面板
        dateFormat: 'yy-mm-dd',//日期格式
        clearText:"清除",//清除日期的按钮名称
        closeText:"关闭",//关闭选择框的按钮名称
        yearSuffix: '年', //年的后缀
        showMonthAfterYear:true,//是否把月放在年的后面
        monthNames: ['一月','二月','三月','四月','五月','六月','七月','八月','九月','十月','十一月','十二月'],
        dayNames: ['星期日','星期一','星期二','星期三','星期四','星期五','星期六'],
        dayNamesShort: ['周日','周一','周二','周三','周四','周五','周六'],
        dayNamesMin: ['日','一','二','三','四','五','六']
    });
    var  pageNo = $('#pageNo').val();
    if($('#pageNo').val()==0){
        pageNo = 1;
    }
    var classRecordPageSize =  $('#classRecordPageSize').val()
    var options = {
        currentPage: pageNo,
        totalPages: classRecordPageSize ,
        alignment:'center',
        tooltipTitles: function (type, page, current) {
            switch (type) {
                case "first":
                    return "首页";
                case "prev":
                    return "上一页";
                case "next":
                    return "下一页";
                case "last":
                    return "尾页";
                case "page":
                    return "第" + page + '页';
            }
        },
        pageUrl: function(type, page, current){
            return rootPath + "/web/class?classId=" + $('#classId').val() + "&dateTime = " +$('#dateTime').val()  + "&pageNo="+page;
        }
    };
    $('#pagers').bootstrapPaginator(options);
});
