<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@include file="header.jsp"%>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/index/css/commodity-page.css">
<div class="container">

	<c:forEach items="${commodities }" var="commodity">
		<div class="card col-xs-12 col-sm-6 col-md-4">
			<img class="card-img" src="<c:out value='${commodity.imgUrl}'/>"
				alt="Card image">
			<div class="card-body">
				<span id="name" class="label label-primary"><c:out
						value='${commodity.name}' /></span>&nbsp;&nbsp;&nbsp;&nbsp; <span
					id="money" class="label label-danger"><c:out
						value='${commodity.money}' /></span>&nbsp;&nbsp;&nbsp;&nbsp; <span
					id="category" class="label label-info"><c:out
						value='${category.name}' /></span>
			</div>
		</div>

	</c:forEach>
</div>

<%@include file="footer.jsp"%>