<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台管理</title>
</head>
<body>
	<form action="addCategory" method="post">
		<input type="text" name="name" id="name">
		<input type="text" name="title" id="title"> 
		<input type="submit" value="添加分类">
	</form>
	
	<p>增加商品</p>
	<form action="addCommodity" method="post" enctype="multipart/form-data">
		选择分类<select name="categoryId">
			
		</select>
		<br>
		名字：<input type="text" name="name"><br>
		描述：<input type="text" name="description"><br>
		价格：<input type="text" name="money"><br>
		图片：<input type="file" name="imgFile" >
		<input type="submit" value="提交">
	</form>
</body>

<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js"></script>
<script>
$(document).ready(function(){
		$.get("PATH/admin/queryAllCategory",function(data,status){
			var jsons=JSON.parse(data);
			for(var i=0;i<jsons.length;i++){
				 $("select").append("<option value='"+jsons[i].id+"'>"+jsons[i].name+"</option>");
			}
		  });
});
</script>
</html>