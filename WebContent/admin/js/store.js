
$.ajax({
    url:"../api/queryStore",
    type:"post",
    success:function (data) {
    	var json;
		parseJSON(data).then(function(o){
			json=o;
			$("#storetitle").val(json.title);
	        $("#phone").val(json.phone);
	        $("#description").val(json.description);
	        $("#boss").val(json.boss);
	        $("#address").val(json.address);
		}).catch(function(err){
			window.location.href="../admin/login.jsp"
		});
        
    }
});

$("#edit").click(function () {
    if($("textarea").attr("readonly")){
        $("input").removeAttr("readonly");
        $("textarea").removeAttr("readonly");
        $("#sbt").show();
    }else{
        $("input").attr("readonly","true");
        $("textarea").attr("readonly","true");

        $("#sbt").hide();
    }
});

$("#sbt").click(function () {
    var boo=true;
    $("input").each(function () {
        if($(this).val()==""){
            boo=false
        }
    });
    if($("textarea").val()==""){
        boo=false
    }
    if(boo){
        $("#store").submit();
    }else{
        $("#message").text("请填写所有信息");
        $("#message").show();
        $("#message").hide(8000);
    }
});