<%@ page language="java" contentType="text/html"%>
<%@ include file="CommonHeader.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link rel="stylesheet" href="<c:url value="/resources/css/MyCSS.css"/>"/>
<style>
body {
    background-image: url("https://image.shutterstock.com/image-photo/closeup-shopping-trolley-on-yellow-260nw-656294992.jpg");
    background-repeat: no-repeat;
   background-size: 100% 100%;
}

</style>
<section class="jumbotron text-center">
    <div class="container">
        <h1 class="jumbotron-heading">YOUR CART ITEMS</h1>
     </div>
</section>
 <div class="container mb-4">
    <div class="row">
        <div class="col-12">
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col"> </th>
                            <th scope="col">Product</th>
                            
                            <th scope="col" class="text-center">Quantity</th>
                            <th scope="col" class="text-right">Price</th>
                            <th scope="col">Total Amount</th>
                            <th> </th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${cartItemList }"  var="cartItem">
                        <tr>
                        <form action="<c:url value="/updateCartItem/${cartItem.cartItemId } "/>" method="post">
                            <td><img src="<c:url value="/resources/images/${cartItem.productId}.jpg"/>" width="50" height ="50"/> </td>
                            <td>${cartItem.productName }</td>
                            
                            <td><input class="form-control" type="text" name="quantity" value="${cartItem.quantity }" /></td>
                            <td class="text-right">${cartItem.price }</td>
                            <td> ${cartItem.price * cartItem.quantity } </td>
                            <td class="text-right"><a href="<c:url value="/deleteCartItem/${cartItem.cartItemId }"/>" class="btn btn-sm btn-danger"><i class="fa fa-trash"> Delete</i> </a> </td>
                        
                            <td><input type="submit" value="Update" class="btn btn-sm btn-info"/></td>
                            </form>
                        </tr>
                       </c:forEach>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td>Sub-Total</td>
                            <td class="text-right">${totalAmount}</td>
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td>Shipping</td>
                            <td class="text-right">${totalAmount/20}</td>
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td><strong>Total</strong></td>
                            <td class="text-right"><strong>${totalAmount+totalAmount/20 }</strong></td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="col mb-2">
            <div class="row">
                <div class="col-sm-12  col-md-6">
                    <a href="<c:url value="/productHome"/>" class="btn btn-block btn-info">Continue Shopping</a>
                </div>
                <div class="col-sm-12 col-md-6 text-right">
                    <a href="<c:url value="/orderConfirm"/>" class="btn btn-block btn-success">Checkout</a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>