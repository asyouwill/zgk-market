require('pgwmodal');

$(function(){

    $('.vip-buy-btn').on('click', function(){
        alert(88)
        $.pgwModal({
            title: '订单确认',
            content: $('.modal').html()
        });
    });

    /* 代理商后台价格接口 */

    var princeUrl = 'http://10.254.130.33:8080/system/agent/getAgentInfo.do?accountId=13';
    $.getJSON('princeUrl',function(res){

    })

});