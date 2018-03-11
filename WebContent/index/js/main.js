
// 滑动页面，navbar隐藏
$(window).bind('scroll', function () {

    $(".collapse").removeClass("in");
    var len = $(this).scrollTop()
    if (len >= 60) {
        $('#nav').hide();
    } else {
        $('#nav').show();
    }
});