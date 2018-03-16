<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/admin/plugins/bootstrap/css/bootstrap.min.css">
<script
	src="${pageContext.request.contextPath}/admin/plugins/jquery-3.2.1.min.js"></script>
	    <script src="${pageContext.request.contextPath}/admin/plugins/bootstrap/js/bootstrap.min.js"></script>
<title>管理员登录</title>
</head>
<body>

	<!-- 图片轮播 -->
	<div id="carousel" class="carousel slide">
		<!-- 轮播（Carousel）指标 -->
		<ol class="carousel-indicators">
			<li data-target="#carousel" data-slide-to="0" class="active"></li>
			<li data-target="#carousel" data-slide-to="1"></li>
			<li data-target="#carousel" data-slide-to="2"></li>
		</ol>
		<!-- 轮播（Carousel）项目 -->
		<div class="carousel-inner">
			<div class="item active">
				<img
					src="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1520680713902&di=0da0a83129b99cfd8b193a5958faa219&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F01dd795853ac9aa8012060c82e1251.jpg"
					alt="First slide">
			</div>
			<div class="item">
				<img
					src="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1520680755208&di=7d83bca295064c473dc396a030b6ef35&imgtype=0&src=http%3A%2F%2Fwww.51pptmoban.com%2Fd%2Ffile%2F2015%2F03%2F20%2Fbf7ed4f04d7d00275fc9f2f0f6e19361.jpg"
					alt="Second slide">
			</div>
			<div class="item">
				<img
					src="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1520680776863&di=48cf44b605625743dcbfaa3ff53976be&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F0177645722017c32f875a399fb6613.jpg%402o.jpg"
					alt="Third slide">
			</div>
		</div>
	</div>

<form class="container" method="post" class="form-horizontal" role="form" action="../api/login" method="post">
<div class="form-group">
        <label for="phone" class="col-sm-2 control-label">账户</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="phone" name="phone"
                   placeholder="请输入账户">
        </div>
    </div>
    <div class="form-group">
        <label for="password" class="col-sm-2 control-label">密码</label>
        <div class="col-sm-10">
            <input type="password" class="form-control" id="password" name="password"
                   placeholder="请输入密码">
        </div>
    </div>
    
        <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button style="width:100%" id="sbt" type="submit" class="btn btn-defaul">登录</button>
        </div>
    </div>

</form>


</body>
</html>