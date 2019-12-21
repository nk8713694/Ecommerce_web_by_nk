<%@ page language="java" contentType="text/html"%>

<%@ include file="CommonHeader.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link rel="stylesheet" href="<c:url value="/resources/css/MyCSS.css"/>"/>

<section class="jumbotron text-center">
    <div class="container">
        <h1 class="jumbotron-heading">Your Order</h1>
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
                            <th scope="col" class="text-right"> </th>
                            <th scope="col">Total Amount</th>
                         
                        </tr>
                    </thead>
                    <tbody>
                    	<c:forEach items="${cartItemList}" var="cartItem">
                        <tr>
                            <td><img src="<c:url value="/resources/images/${cartItem.productId}.jpg"/>" width="50" height="50"/> </td>
                            <td>${cartItem.productName}</td>
                            <td>${cartItem.quantity}</td>
                            <td class="text-right">${cartItem.price}</td>
                             
                            <td class="text-right">${cartItem.price * cartItem.quantity}</td>
                            <td class="text-right">
                          	</td>
            
                        </tr>
                        </c:forEach>
                        
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td>Sub-Total</td>
                            <td class="text-right">${totalAmount}</td>
                            <td></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                           
                            <td>Shipping</td>
                            <td class="text-right">${totalAmount/20}</td>
                             <td></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                           
                            <td><strong>Total</strong></td>
                            <td class="text-right"><strong>${totalAmount + (totalAmount/20)}</strong></td>
                            <td></td>
                        </tr>
                        
                        <tr>
                        	<form action="<c:url value="/updateAddress"/>" method="post">
                        	<td>Deliver Here</td>
                        	<td colspan="4">
                        	<textArea cols="80" rows="5" name="address">${addr}</textArea>
                        	</td>
                        	<td>
                        		<input type="submit" value="Update Address" class="btn btn-success"/>
                        	</td>
                        	</form>
                        </tr>
                        
                    </tbody>
                </table>
            </div>
        </div>
        <div class="col mb-2">
            <div class="row">
                <div class="col-sm-12  col-md-6">
                    <a href="<c:url value="/cart"/>" class="btn btn-block btn-info">Edit Cart</a>
                </div>
                <div class="col-sm-12 col-md-6 ">
                    <a href="<c:url value="/paymentPage"/>" class="btn btn-block btn-success">Payment</a>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>