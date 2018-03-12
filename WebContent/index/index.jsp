<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="header.jsp" %>

 <link rel="stylesheet" href="${pageContext.request.contextPath}/index/css/index.css">
 <div id="con" class="container-fluid">
     
     	<c:forEach items="${categories}" var="category">
     	
     	<div class="category" style="background:url(<c:out value='${category.imgUrl}'/> )">
            
        </div>
     	
     	</c:forEach>
        
    </div>

<%@include file="footer.jsp" %>