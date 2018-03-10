
$(document).ready(function() {
    /**
     * 上传图片部分
     * */
    $("#upload-img").click(function () {
        document.getElementById("imgFile").click();
    });
    var x = new FileReader;
    document.forms[0].elements[0].onchange = function () {
        x.readAsDataURL(this.files[0]);
    };
    x.onloadend = function () {
        //document.images[0].src=this.result;
        $("#upload-img").css("background-image", "url(" + this.result + ")");
    };

    /**
     * 获得商品类别
     * */
    $.ajax({
        url:"http://localhost:8080/SHOP/api/queryAllCategory",
        success:function(data){
            var json=JSON.parse(data);
            for(var i=0;i<json.length;i++){
                $("#categoryId").append("<option value='"+json[i].id+"'>"+json[i].name+"</option>")
            }
        }});

});