<%@ page language="java" contentType="text/html"%>
<%@ include file="CommonHeader.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<style>
body {
    background-image: url("https://cdn.hipwallpaper.com/i/75/53/0cFvKO.jpg");
    background-repeat: no-repeat;
   background-size: 100% 100%;
}

</style>
<div class="container">

	<br /> <br />

	<div class="row text-center text-lg-left">
		<c:forEach items="${productList}" var="product">
			<div class="col-lg-3 col-md-4 col-sm-6 col-xs-12">
				<c:if test="${product.stock > 0}">
					<a href="<c:url value="/totalProductDisplay/${product.productId}"/>" class="d-block mb-4 h-100">
				</c:if>
				<img class="img-fluid img-thumbnail"
					src="<c:url value="/resources/images/${product.productId}.jpg"/>"
					width="100px" height="100px" /> 
					</a>
				<p>Price : ${product.price}/-</p>
		
				<p>Stock : <c:if test="${product.stock > 0}">${product.stock} </c:if>
					<c:if test="${product.stock <= 0}">
					<font color="red">out of stock</font> 
					</c:if>
				</p>
		
				<p><h4>${product.productName}</h4></p> 
			</div>
		</c:forEach>
	</div>


</div>

</body>
</html>