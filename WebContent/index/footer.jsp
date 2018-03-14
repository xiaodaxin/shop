<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
           
           
           
           
           
<a id="callme" href="tel:<c:out value='${store.phone }'/>"><img  src="${pageContext.request.contextPath}/index/img/phone.png"></a>           
           
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
            
			 <div id="gis" class="col-xs-12 col-md-12">
               <br>
            </div>
            
            <div id="gis" class="col-xs-12 col-md-12">
                <strong>
                   	技术支持：</strong>肖大昕(13667084900)
            </div>

        </div>
    </div>

</body>
</html>