<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@include file="header.jsp"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/index/css/about.css">

<div id="head-img">
	<img alt="" src="/imgs/store.jpg">
</div>

<div class="container">
	<hr>
	<h1>我是谁</h1>
	<hr>
	<p>${store.description }</p>
	
	<br>

	<h1>我在哪</h1>
	<hr>
	<script type="text/javascript"
		src="//api.map.baidu.com/api?ak=xY4dV0Ab3kQvRQ21wO8hclRsp4B66IG1&type=lite&v=1.0"></script>
	<div id=map></div>
	<script type="text/javascript">
		var map = new BMap.Map('map');
		// 创建地图实例
		var point = new BMap.Point(114.253363,26.959692);
		// 创建点坐标
		map.centerAndZoom(point, 18);
		// 初始化地图， 设置中心点坐标和地图级别
		var marker = new BMap.Marker(point);        // 创建标注    
		map.addOverlay(marker);                     // 将标注添加到地图中 	
	</script>
	
	<br>
	<h1>我合作</h1>
	<hr>
	<div class="hezuo col-xs-12 col-sm-6 col-md-4">
		<img alt="首尔电器" src="http://www.qianyan.biz/qy/images40/9/m1_logo.gif">
	</div>
	<div class="hezuo col-xs-12 col-sm-6 col-md-4">
		<img alt="欧普照明" src="http://www.opple.com.cn/web/ucan/images/common/logo.png">
	</div>
	<div class="hezuo col-xs-12 col-sm-6 col-md-4">
		<img alt="蒙娜丽莎卫浴" src="http://www.mongnlsweiyu.com/front/views/common/images/logo.jpg">
	</div>
	<div class="hezuo col-xs-12 col-sm-6 col-md-4">
		<img alt="金牛管业" src="http://www.wuhankb.com/r/cms/jngy/default/images/logo.png">
	</div>
	

</div>



<%@include file="footer.jsp"%>