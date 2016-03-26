define(function (require, exports, module) {
    var $ = require('$');
    var UI = {
        $submitBtn: $('#submit-btn'),
        $userName: $('#userName'),
        $pwd: $('#pwd')
    };
    $('#video-login input').focus(function(){
        $('.error-tips').hide().text("");
    });
    $('#pwd').keydown(function(){
        if(event.keyCode == 13){
            $('#submit-btn').click();
        }
    });
    UI.$submitBtn.on('click', function () {
        // 用户名
        if (UI.$userName.val().trim() == "") {
            $('.error-tips').show().text("用户名不能为空！");
            return false;
        }
        if (UI.$userName.val().length != 0) {
            var mobile = /^1[3|4|5|6|7|8|9][0-9]{1}[0-9]{8}$/;
            var mobileVal = UI.$userName.val();
            var mobileResult = mobile.test(mobileVal);
            if (mobileResult == false) {
                $('.error-tips').show().text("请填写正确的手机号码！");
                return false;
            } else {
                $('#form-tip1').hide().find('.form-info').text("");
            }
        }
        // 密码
        if (UI.$pwd.val().trim() == "") {
            $('.error-tips').show().text("密码不能为空！");
            return false;
        }
        $.ajax({
            type: "POST",
            url: rootPath + "/web/login/checkLogin",
            data: {
                userName: UI.$userName.val(),
                pwd: UI.$pwd.val()
            },
            success: function (msg) {
                if (msg.bizData !== "OK") {
                    $('.error-tips').show().text(msg.bizData);
                    $('#form-tip1,#form-tip2').hide().text("");
                } else {
                    window.location.href = rootPath + "/web/index";
                }
            }
        });
    })

});
