
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
        url:"../api/queryAllCategory",
        success:function(data){
            var json=JSON.parse(data);
            for(var i=0;i<json.length;i++){
                $("#categoryId").append("<option value='"+json[i].id+"'>"+json[i].name+"</option>")
            }
        }});
    
    
    $("#sbt").click(function () {
        console.log("click");
        var boo=true;
        $("input").each(function () {
            if ($(this).val()=='') {
                boo=false
            }
        })

            if ($("#description").val()=='') {
                boo=false
            }

            if($("#categoryId").val()=='') {
            boo=false
        }

        if(boo){
            $("form").submit()
        }else{
            alert("请输入完整信息")
        }

    })
});