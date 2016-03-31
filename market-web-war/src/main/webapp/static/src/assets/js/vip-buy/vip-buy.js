require('pgwmodal');


$(function(){
    $('#header-title').text('订单');
    $('.vip-buy-btn').on('click', function(){
        $.pgwModal({
            title: '订单确认',
            content: $('.modal').html()
        });
    });


    /* 代理商后台价格接口 */
    var princeUrl = 'http://10.254.130.33:8080/system/agent/getAgentInfo.do?accountId=13';
    $.getJSON(princeUrl,function(res){
        console.log(princeUrl)
    })

});