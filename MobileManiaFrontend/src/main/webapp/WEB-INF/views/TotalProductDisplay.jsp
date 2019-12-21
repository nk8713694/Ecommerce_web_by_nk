<%@ page language="java" contentType="text/html"%>
<%@ include file="CommonHeader.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link rel="stylesheet" href="<c:url value="/resources/css/MyCSS.css"/>"/>

<style>
body {
    background-image: url("https://cdn.hipwallpaper.com/i/75/53/0cFvKO.jpg");
    background-repeat: no-repeat;
   background-size: 100% 100%;
}


</style>
<div class="container">

	<br /> <br />
	
			<div class="card">
			<div class="container-fliud">
				<div class="wrapper row">
					<div class="preview col-md-6">
						
						<div class="preview-pic tab-content">
						  <div class="tab-pane active" id="pic-1"><img src="<c:url value="/resources/images/${product.productId}.jpg"/>"/></div></div>
						<ul class="preview-thumbnail nav nav-tabs">
						
						</ul>
						
					</div>
					<div class="details col-md-6">
						<h3 class="product-title">${product.productName}</h3>
						<div class="rating">
							<div class="stars">
								<span class="fa fa-star checked"></span>
								<span class="fa fa-star checked"></span>
								<span class="fa fa-star checked"></span>
								<span class="fa fa-star"></span>
								<span class="fa fa-star"></span>
							</div>
							<span class="review-no">41 reviews</span>
						</div>
						<form action="<c:url value="/addToCart/${product.productId}"/>" method="post">
						<p class="product-description">${product.productDesc}</p>
						<h4 class="price">current price: <span>Rs.${product.price}/-</span></h4>
						<p class="vote"><strong>91%</strong> of buyers enjoyed this product! <strong>(87 votes)</strong></p>
						<h5 class="sizes">Quantity
							<select name="quantity">
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
							</select>
						</h5>
						<h5 class="colors">Stock :${product.stock}</h5>
						<div class="action">
							<button class="add-to-cart btn btn-default" type="submit">add to cart</button>
						</div>
						</form>
					</div>
				</div>
			</div>
		</div>

</body>
</html>