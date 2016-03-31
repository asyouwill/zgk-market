define(['commonCss', '.'], function () {

    //var domainStr = 'zhigaokao.cn'; //正式
    //var domainStr = 'test.zhigaokao.cn'; //测试
    var domainStr = 'zhigaokao.com:3005';


    //浏览器判断 开始=============================
    var Sys = {};
    var ua = navigator.userAgent.toLowerCase();
    var s;
    (s = ua.match(/msie ([\d.]+)/)) ? Sys.ie = s[1] : 0;
    var vesion = parseInt(Sys.ie);
    if (Sys.ie && vesion <= 8) {
        window.location.href = '/terrible-broswer.html';
    }
    //公共头尾=============================
    $('head').prepend(require('html!../../meta.html'));
    var noHeaderFooterUrl = window.location.pathname;
    if (noHeaderFooterUrl != '/login.html' && noHeaderFooterUrl != '/class-college-detail.html') {
        $('body')
            .prepend(require('html!../../header.html'))
            .append(require('html!../../footer.html'));
    }
    //获取域名前缀=============================
    var urlDomain = window.location.hostname + '';
    var urlArr = urlDomain.split('.');
    var provinceKey = urlArr[0];


    if (provinceKey == "www" || provinceKey == 'undefined') {
        window.location.assign('http://zj.zhigaokao.cn');
    }
    console.log(href = "http://' + provinceKey + '.test.zhigaokao.com:3005/")
    $('#current-province').text($('#select-province li a[href="http://' + provinceKey + '.zhigaokao.cn/"]').text())
    //$('#current-province').text($('#select-province li a[href="http://' + provinceKey + '.test.zhigaokao.cn/"]').text())


    //判断是否登录=============================
    var cookie = require('cookie');
    var loginUserKey = cookie.getCookieValue('userKey');
    console.log(cookie.getCookieValue('isLogin'))
    if (cookie.getCookieValue('isLogin') == 'true') {
        $('#login-front').hide();
        $('#login-end').show();
        $('.current-province').addClass('isLogin');

        if (provinceKey != loginUserKey) {
            window.location.assign('http://' + $.trim(loginUserKey) + '.zhigaokao.cn/index.html');
        }
    } else {
        console.log("未登录")
        $('#login-front').show();
        $('#login-end').hide();
        filterUrl();
        $('.current-province').removeClass('isLogin');
        $('.select-province').on('click', 'a', function () {
            $('#current-province').text($(this).text());
        });
    }


    //获取登录用户信息=============================


    //
    //
    ////var icon = cookie.getCookieValue('icon');
    //var icon = window.localStorage.icon;
    //console.log(icon)
    //var userName = cookie.getCookieValue('userName');
    //var imgIco = require('../../img/icon_default.png');
    //if (icon == 'undefined') {
    //    icon = imgIco;
    //}
    //$('#header-user-avatar,.user-avatar').attr('src', icon);
    //$('#header-user-name,.user-name').text(userName);

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
    //地址过滤=============================
    var paths = window.location.pathname.split('/');
    var pagePath = paths[paths.length - 1];
    switch (pagePath) {
        case 'index.html':
            $('#nav-index').addClass('active');
            break;
        case 'news-hot.html':
        case 'news-detail.html':
        case 'news-policy.html':
        case 'news-schedule.html':
        case 'news-online-interactive.html':
        case 'data-gk-word.html':
            $('#nav-news-hot').addClass('active');
            break;
        case 'data-school-info.html':
        case 'data-professional-info.html':
        case 'data-school-enrollment.html':
        case 'data-occupational-info.html':
        case 'data-occupational-detail.html':
        case 'data-school-detail.html':
        case 'data-professional-detail.html':
        case 'data-area-scores.html':
            $('#nav-data-school-info').addClass('active');
            break;
        case 'class-college.html':
        case 'class-college-detail.html':
            $('#nav-class-college').addClass('active');
            break;
        case 'predict-degree.html':
        case 'predict-school.html':
        case 'predict-professional.html':
        case 'predict-result.html':
        case 'predict-volunteer.html':
        case 'predict-selSchool.html':
            $('#nav-predict-degree').addClass('active');
            break;
        default:
            break;
    }

    function filterUrl() {
        var pathName = window.location.pathname.split('/');
        var pageName = pathName[pathName.length - 1];
        switch (pageName) {
            case 'index.html':
                $('#nav-index').addClass('active');
                break;
            case 'user-account-info.html':
            case 'user-vip.html':
            case 'user-collection.html':
            case 'user-order.html':
            //case 'user-target.html':
            case 'user-answer':
            case 'user-service.html':
            case 'user-report.html':
            //case 'predict-degree.html':
            case 'class-college-detail.html':
            case 'predict-volunteer.html':
                window.location.assign('http://' + window.location.host + '/login.html')
                break;
            default:
                break;
        }
    }

    var isLogin = function () {
        return cookie.getCookieValue('isLogin')
    };

    var INTERFACE_URL = require('urlConfig');
    //ajax拉取数据 IE8 跨域
    function ajaxFun(url, method, data, callback, callbackError) {
        if (cookie.getCookieValue('token')) {
            data.token = cookie.getCookieValue('token');
        }
        data.userKey = provinceKey;
        var strParameter = '';
        for (var i in data) {
            strParameter += "&" + i + "=" + data[i];
        }
        var Sys = {};
        var ua = navigator.userAgent.toLowerCase();
        var s;
        (s = ua.match(/msie ([\d.]+)/)) ? Sys.ie = s[1] : 0;
        var vesion = parseInt(Sys.ie);

        if (Sys.ie && vesion >= 8 && vesion < 10) {
            $.ajax({
                url: url,
                type: method,
                data: data || {},
                dataType: "jsonp",
                jsonp: "callback",
                success: callback,
                error: callback
            });
        } else {
            $.ajax({
                url: url,
                type: method,
                data: data || {},
                success: function (res) {
                    callback(res);
                },
                error: function (res) {
                    if (callbackError && typeof(callbackError) === "function") {
                        callbackError(res);
                    }
                }
            });
        }
    };

    var getLinkey = function getLinkey(name) {
        var reg = new RegExp("(^|\\?|&)" + name + "=([^&]*)(\\s|&|$)", "i");
        if (reg.test(window.location.href)) return unescape(RegExp.$2.replace(/\+/g, " "));
        return "";
    };

    //ajaxFun('http://api.map.baidu.com/location/ip?ak=or0sMLPMY3fDxrb4cDG9MG9O&ip=&coor=bd09ll', 'GET', {}, function (result) {
    //    console.log(result)
    //});

    ajaxFun(INTERFACE_URL.getUserInfo, 'GET', {}, function (res) {
        if (res.rtnCode == '0000000') {
            var personListData = res.bizData;
            var avatar = '';
            var imgIco = require('../../img/icon_default.png');
            if (personListData.icon == '' || personListData.icon == null) {
                avatar = imgIco;
            } else {
                avatar = personListData.icon
            }
            var subjectType = res.bizData.typeId;
            var universityName = res.bizData.universityName;
            var achievement = res.bizData.achievement;
            var forecaset = res.bizData.forecaset;
            cookie.setCookie("subjectType", subjectType, 4, "");
            cookie.setCookie("universityName", universityName, 4, "");
            cookie.setCookie("achievement", achievement, 4, "");
            cookie.setCookie("forecaset", forecaset, 4, "");

            $('#header-user-name').text(personListData.name);
            $('#avatar-img,.user-avatar').attr('src', avatar);
            $('#user-name').val(personListData.name);
            window.localStorage.icon = avatar;
        }
    });


    //广西省份展示智能填报菜单
    //var provinceName = $('#current-province').text();
    //if (provinceName != '广西') {
    //    $('.sub-menu').find('a[href="/predict-volunteer.html"]').hide();
    //    $('.sidebar').find('a[href="/predict-volunteer.html"]').parent().remove();
    //}


    if(provinceKey!='gx'){
        $('.volunteer-links').remove();
        $('.sidebar').find('a[href="/predict-volunteer.html"]').parent().remove();
    }


    function drawToast(message) {
        var alert = document.getElementById("toast");
        if (!alert) {
            var toastHTML = '<div id="toast">' + message + '</div>';
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


    var toast = function() {
        var intervalCounter = null;

        function drawToast(message) {
            var alert = document.getElementById("toast");
            if (!alert) {
                var toastHTML = '<div id="toast">' + message + '</div>';
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

        drawToast(str);
    }








    return {
        isLogin: isLogin, //判断是否登录成功
        ajaxFun: ajaxFun,//数据拉取
        getLinkey: getLinkey,//url获取参数
        drawToast:drawToast,//弹框
        INTERFACE_URL: INTERFACE_URL,
        cookie: cookie,
        domain: domainStr,
        provinceKey: provinceKey,
        toast: toast
    };


});




