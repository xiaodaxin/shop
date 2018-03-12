<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>${store.title}</title>
    <link rel="icon" href="${pageContext.request.contextPath}/index/img/favicon.ico" type="image/x-icon" />
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/index/img/favicon.ico" type="image/x-icon" />
    <meta name="description" content="家中如果拥有合适的照明，不仅能为实际工作照明，更能让人感觉舒适" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/index/plugins/bootstrap/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/index/plugins/jquery-3.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/index/plugins/bootstrap/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/index/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/index/css/index.css">
    <script src="${pageContext.request.contextPath}/index/js/main.js"></script>
</head>
<body>

    <!-- 导航栏 -->
    <nav id="nav" class="navbar navbar-fixed-top navbar-style" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#example-navbar-collapse">
                    <span class="sr-only">切换导航</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">${store.title}</a>
            </div>
            <div class="collapse navbar-collapse" id="example-navbar-collapse">
                <ul class="nav navbar-nav">
                
                
                <c:forEach items="${categories }" var="category">
                	<li>
                        <a href="comodity.jsp"><c:out value="${category.name}" /></a>
                    </li>
                	
                </c:forEach>
                </ul>
            </div>
        </div>
    </nav>
    
     <div id="con" class="container-fluid">
     
     	<c:forEach items="${categories}" var="category">
     	
     	<div class="category" style="background:url(<c:out value='${category.imgUrl}'/> )">
            
        </div>
     	
     	</c:forEach>
        
    </div>
    
    
    <div id="footer" class="container">
        <div class="raw">
            <div class="col-xs-12 col-md-6">
                <strong>
                    <span class="glyphicon glyphicon-phone-alt"></span>：</strong>
                <a href="tel:<c:out value='${store.phone }'/>"><c:out value='${store.phone }'/>(<c:out value='${store.boss }'/>)</a>
            </div>

            <div class="col-xs-12 col-md-6">
                <strong>
                    <span class="glyphicon glyphicon-tag"></span>：</strong><c:out value='${store.address }'/>
            </div>
            
            <div class="col-xs-12 col-md-6">
                <strong>
                   	技术支持：</strong>肖大昕（13667084900）
            </div>

        </div>
    </div>

</body>
</html>