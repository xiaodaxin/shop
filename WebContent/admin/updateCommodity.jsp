<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/plugins/bootstrap/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/admin/plugins/jquery-3.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/admin/plugins/bootstrap/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<style type="text/css">
html,body{
    width: 100%;
    height: 100%;
    margin: 0;
    padding: 0;
}
#header{
    width: 100%;
    height: 50px;
    background: skyblue;
    padding-left: 10px;
    padding-right: 10px;
}
#header #shouye{
	height:50px;
    line-height: 50px;
    text-align: center;
    color: white;
    font-size: 30px;
    width: 50px;
}

#header #title{
    position: absolute;
    left: 0;
    right: 0;
    height: 50px;
    color: white;
    line-height: 50px;
    font-size: 25px;
    text-align: center;
}

</style>
</head>
<body>

<div id="header">
    <span id="title">商品修改</span>
    <a id="shouye" href="${pageContext.request.contextPath}/admin/index.html">
        <span class="glyphicon glyphicon-home"></span>
    </a>
</div>

<form class="form-horizontal container" role="form" action="updateCommodity">

    <div class="form-group">
        <label for="name" class="col-sm-2 control-label">商品名称:</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" name="name" id="name" value=<c:out value="${commodity.name }" /> >
            <input style="display:none" type="text" class="form-control" name="id" id="id" value=<c:out value="${commodity.id }" /> >
        </div>
    </div>
    
        <div class="form-group">
        <label for="money" class="col-sm-2 control-label">商品价格:</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" name="money" id="money" value=<c:out value="${commodity.money }" /> >
        </div>
    </div>
    
    <div class="form-group">
        <label for="name" class="col-sm-2 control-label">商品描述:</label>
        <div class="col-sm-10">
            <textarea  class="form-control" name="description" ><c:out value="${commodity.description }"/></textarea>
        </div>
    </div>
    
       <div class="form-group">
       <div class="col-xs-12 col-sm-12">
            <button style="width: 100%;" id="sbt" type="submit" class="btn btn-defaul">提交</button>
        </div>
    </div>

</form>


</body>
</html>