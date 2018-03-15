<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/admin/plugins/bootstrap/css/bootstrap.min.css">
<script
	src="${pageContext.request.contextPath}/admin/plugins/jquery-3.2.1.min.js"></script>
<title>二维码</title>
<style type="text/css">
html, body {
	width: 100%;
	height: 100%;
	margin: 0;
	padding: 0;
}

#header {
	width: 100%;
	height: 50px;
	background: skyblue;
	padding-left: 10px;
	padding-right: 10px;
}

#header #shouye {
	line-height: 50px;
	text-align: center;
	color: white;
	font-size: 30px;
}

#header #title {
	color: white;
	line-height: 50px;
	position: absolute;
	left: 0;
	right: 0;
	height: 50px;
	font-size: 25px;
	text-align: center;
}

.qr {
		width: 100%;
	}
</style>
</head>
<body>
	<div id="header">
		<span id="title">二维码</span> <a id="shouye"
			href="${pageContext.request.contextPath}/admin/index.html"> <span
			class="glyphicon glyphicon-home"></span>
		</a>
	</div>

	<div class="container">
		<hr>
		<h5>顾客端二维码</h5>
		<div class="row">
			<div class="col-xs-12 col-sm-6 col-md-12">
				<img class="qr"
					src="${pageContext.request.contextPath}/admin/img/gk.png">
			</div>
		</div>
		<hr>
		<h5>管理端二维码</h5>
		<div class="col-xs-12 col-sm-6 col-md-12">
			<img class="qr"
				src="${pageContext.request.contextPath}/admin/img/gl.png">
		</div>
	</div>
</body>
</html>