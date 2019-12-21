<%@ page language="java" contentType="text/html"%>
<%@ include file="CommonHeader.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link rel="stylesheet" href="<c:url value="/resources/css/payment.css"/>"/>

<div class="container">
    <div class="row">
        <div class="col-xs-12 col-md-4">
        <form action="<c:url value="/pay"/>" method="post" role="form">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">
                        Payment Details
                    </h3>
                </div>
             
                <div class="panel-body">
                   
                    <div class="form-group">
                    	<label for="paymentMode">Payment Mode</label>
                    	<div class="input-group">
                    	<input type="radio" class="form-control" id="paymentMode" name="pmode" value="CC">Credit Card
                    	<input type="radio" class="form-control" id="paymentMode" name="pmode" value="COD">Cash on Delivery
                    	</div>
                    </div>
                    <div class="form-group">
                        <label for="cardNumber">
                            CARD NUMBER</label>
                        <div class="input-group">
                            <input type="text" class="form-control" id="cardNumber" placeholder="Valid Card Number"
                                required autofocus />
                            <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-7 col-md-7">
                            <div class="form-group">
                                <label for="expityMonth">
                                    EXPIRY DATE</label>
                                <div class="col-xs-6 col-lg-6 pl-ziro">
                                    <input type="text" class="form-control" id="expityMonth" placeholder="MM" required />
                                </div>
                                <div class="col-xs-6 col-lg-6 pl-ziro">
                                    <input type="text" class="form-control" id="expityYear" placeholder="YY" required /></div>
                            </div>
                        </div>
                        <div class="col-xs-5 col-md-5 pull-right">
                            <div class="form-group">
                                <label for="cvCode">
                                    CVV</label>
                                <input type="password" class="form-control" id="cvCode" placeholder="CVV" required />
                            </div>
                        </div>
                    </div>
                    
                </div>
            </div>
            <ul class="nav nav-pills nav-stacked">
                <li class="active"><a href="#"><span class="badge pull-right"><span class="glyphicon glyphicon-inr"></span>${totalAmount}</span> Final Payment</a>
                </li>
            </ul>
            <br/>
            <input type="submit" value="Pay" class="btn btn-success btn-lg btn-block"/>
        </div>
        </form>
    </div>
</div>



</body>
</html>