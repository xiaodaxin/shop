/**
 * 获得商品类别
 */
$.ajax({
    url : "../api/queryAllCategory",
    success : function(data) {
        var json = JSON.parse(data);
        for (var i = 0; i < json.length; i++) {

            var context = '<div class="card col-xs-12 col-sm-6 col-md-4" >'
                + '<img class="card-img" src="'
                + json[i].imgUrl
                + '">'
                + '<div class="card-body">'
                + '<span id="name" class="label label-primary">'
                + json[i].name
                + '</div>'
                + '</div>';
            $("#category").append(context);
        }
    }
});