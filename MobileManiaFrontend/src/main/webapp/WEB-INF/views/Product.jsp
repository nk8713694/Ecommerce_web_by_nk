<%@ page language="java" contentType="text/html"%>
<%@ include file="CommonHeader.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<style>
body {
    background-image: url("https://t3.ftcdn.net/jpg/02/66/61/88/500_F_266618803_SGH2u1Jxdy9cgUwKyn84doVJBw1IrtU9.jpg");
    background-repeat: no-repeat;
   background-size: 100% 100%;
}

</style>
<div class="container">

	<br />
	<br />
	

<form:form action="insertProduct" modelAttribute="product" method="post" enctype="multipart/form-data">
	<table class="table table-bordered">
		<tr>
			<td colspan="2">
				<center>
					Product Information
				</center>
			</td>
		</tr>
		<tr>
			<td>Product Name</td>
			<td> <form:input path="productName"/></td>
		</tr>
		<tr>
			<td>Product Desc</td>
			<td> <form:textarea path="productDesc"/></td>
		</tr>
		<tr>
			<td>Category</td>
			<td> 
				<form:select path="categoryId">
					<form:option value="0" label="--Select List--"/>
					<form:options items="${categoryList}"/>
				</form:select>
			</td>
		</tr>
		<tr>
			<td>Supplier</td>
			<td> <form:input path="supplierId"/></td>
		</tr>
		<tr>
			<td>Price</td>
			<td> <form:input path="price"/></td>
		</tr>
		<tr>
			<td>Stock</td>
			<td> <form:input path="stock"/></td>
		</tr>
		<tr>
			<td>Product Image</td>
			<td> <form:input type="file" path="pimage"/></td>
		</tr>
		<tr>
			<td colspan="2"> 
				<center>
				<input type="submit" value="Insert Product" class="btn btn-success"/>
				</center>
			</td>
		</tr>
	
	</table>
</form:form>

<table class="table table-bordered">
		<tr bgcolor="orange">
			<td colspan="7">
				<center>
					<h4>Product Information</h4>
				</center>
			</td>
		</tr>
		<tr>
			<td>Product Id</td>
			<td>Product Name</td>
			<td>Category</td>
			<td>Supplier</td>
			<td>Stock</td>
			<td>Price</td>
			<td>Operation</td>
		</tr>
		<c:forEach items="${productList}" var="product">
			<tr>
				<td>${product.productId}</td>
				<td>${product.productName}</td>
				<td>${product.categoryId}</td>
				<td>${product.supplierId}</td>
				<td>${product.stock}</td>
				<td>${product.price}</td>
				<td>
					<a href="<c:url value="/deleteProduct/${product.productId}"/>">DELETE</a>
					&nbsp;&nbsp;/&nbsp;&nbsp;
					<a href="<c:url value="/editProduct/${product.productId}"/>">EDIT</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	


</div>
</body>
</html>