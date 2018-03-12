$(document).ready(function () {
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


    $("#sbt").click(function () {
        console.log("click");
        var boo=true;
        $("input").each(function () {
            if ($(this).val()=='') {
                boo=false
            }
        });

        if(boo){
            $("form").submit()
        }else{
            alert("请输入完整信息")
        }
    })

});