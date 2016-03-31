//var domainStr = 'zhigaokao.cn'; //正式
//var domainStr = 'test.zhigaokao.cn'; //测试
var domainStr = 'zhigaokao.com:3005';

//获取域名前缀=============================
var urlDomain = window.location.hostname + '';
var urlArr = urlDomain.split('.');
var provinceKey = urlArr[0];
if (provinceKey == "www" || provinceKey == 'undefined') {
    window.location.assign('http://zj.zhigaokao.cn');
}
$('#current-province').text($('#select-province li a[href="http://' + provinceKey + '.zhigaokao.cn/"]').text())


//判断是否登录=============================
var cookie = require('cookie');
$('body').on('click', '#logout-btn', function () {
    cookie.deleteCookie('isLogin', '');
    cookie.deleteCookie('token', '');
    cookie.deleteCookie('icon', '');
    cookie.deleteCookie('phone', '');
    cookie.deleteCookie('subjectType', '');
    cookie.deleteCookie('userKey', '');
    cookie.deleteCookie('userName', '');
    cookie.deleteCookie('vipStatus', '');
    window.location.assign('http://' + window.location.host + '/index.html')
});

var isLogin = function () {
    return cookie.getCookieValue('isLogin')
};

function ajaxFun(url, method, data, callback) {
    if (cookie.getCookieValue('token')) {
        data.token = cookie.getCookieValue('token');
    }
    data.userKey = provinceKey;
    var strParameter = '';
    for (var i in data) {
        strParameter += "&" + i + "=" + data[i];
    }
    $.ajax({
        url: url,
        type: method,
        data: data || {},
        success: callback,
        error: callback
    });
};


var getLinkey = function getLinkey(name) {
    var reg = new RegExp("(^|\\?|&)" + name + "=([^&]*)(\\s|&|$)", "i");
    if (reg.test(window.location.href)) return unescape(RegExp.$2.replace(/\+/g, " "));
    return "";
};


var tips = function tips(obj, txt) {
    $(obj).text(txt).fadeIn('1500');
    setTimeout(function () {
        $(obj).fadeOut('1500');
    }, 1000);
};

//return {
//    isLogin: isLogin,
//    ajaxFun: ajaxFun,
//    getLinkey: getLinkey,
//    cookie: cookie,
//    domain: domainStr,
//    provinceKey: provinceKey,
//    tips: tips
//};




function drawToast(message,btns) {
    var intervalCounter = null;
    var alert = document.getElementById("toast");
    if (!alert) {
        var toastHTML = '<div id="toast">'
            + message;

        if(btns){
            toastHTML +='btns'
        }

        toastHTML+= '</div>';

        document.body.insertAdjacentHTML('beforeEnd', toastHTML);
    } else {
        alert.style.opacity = .9;
    }
    intervalCounter = setInterval(function () {
        var alert = $("#toast");
        alert.css('opacity', 0).remove();
        clearInterval(intervalCounter);
    }, 1000);
}







exports.isLogin = isLogin;
exports.ajaxFun = ajaxFun;
exports.getLinkey = getLinkey;
exports.domain = domainStr;
exports.provinceKey = provinceKey;
exports.tips = tips;
exports.drawToast = drawToast;














