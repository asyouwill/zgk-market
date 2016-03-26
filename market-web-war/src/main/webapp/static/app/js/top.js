define(function (require, exports, module) {

  var $ = require('$');
  var $loginToggleBox = $('#loginToggleBox'),
      $loginToggleFun = $('#loginToggleFun'),
      timer = null;
  $loginToggleBox.on('mouseover', [$loginToggleFun], function () {
    clearInterval(timer);
    setTimeout(function () {
      $loginToggleFun.show();
    }, 300);
  });
  $loginToggleBox.on('mouseout', [$loginToggleFun], function () {
    clearInterval(timer);
    timer = setTimeout(function () {
      $loginToggleFun.hide();
    }, 300);
  })

  $("#common-logo").click(function(){
    window.location.href=rootPath + "/index";
  });






  // 意见反馈
  if ($("#ui_feedback").length) {
    (function () {
      var text = $("#ui_feedback").html();
      $("#ui_feedback").hover(function () {
        $(this).empty().text("意见反馈");
      }, function () {
        $(this).empty().html(text);
      });
    }())
  }
  if ($("#ui_back_top").length) {
    (function () {
      var text = $("#ui_back_top").html();
      $("#ui_back_top").hover(function () {
        $(this).empty().text("返回顶部");
      }, function () {
        $(this).empty().html(text);
      });
    }())
  }

  // 返回顶部
  $(window).on('scroll',function(){
    var st = $(document).scrollTop();
    if( st>300 ){
      $('#ui_back_top').fadeIn(function(){
        $(this).removeClass('dn');
      });
    }else{
      $('#ui_back_top').fadeOut(function(){
        $(this).addClass('dn');
      });
    }
  });
  $('#ui_back_top').on('click',function(){
    $('html,body').animate({'scrollTop':0},500);
  });








});
