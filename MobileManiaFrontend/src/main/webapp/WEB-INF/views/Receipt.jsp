<%@ page language="java" contentType="text/html"%>
<%@ include file="CommonHeader.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link rel="stylesheet" href="<c:url value="/resources/css/payment.css"/>"/>

 <div class="invoice overflow-auto">
        <div style="min-width: 600px">
            <header>
                <div class="row">
                    <div class="col">
                        <a target="_blank" href="https://lobianijs.com">
                            <img src="https://image.shutterstock.com/z/stock-vector-receipt-line-icon-outline-vector-sign-linear-style-pictogram-isolated-on-white-symbol-logo-704532685.jpg" data-holder-rendered="true" height="50" width="50" />
                        </a>
                    </div>
                    <div class="col company-details">
                        <h2 class="name">
                            <a target="_blank" href="https://lobianijs.com">
                            Mobile Mania
                            </a>
                        </h2>
                        <div>${addr}</div>
                    </div>
                </div>
            </header>
            <main>
                <div class="row contacts">
                    <div class="col invoice-to">
                        <div class="text-gray-light">INVOICE TO:</div>
                        <h2 class="to">${orderInfo.username}</h2>
                        <div class="address">${addr}</div>
                       
                    </div>
                    <div class="col invoice-details">
                        <h1 class="invoice-id">${orderInfo.orderId}</h1>
                        <div class="date">Date of Invoice: ${orderInfo.orderDate}</div>
                        <div class="date">Due Date: NA</div>
                    </div>
                </div>
                <table border="0" cellspacing="0" cellpadding="0">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th class="text-left">PRODUCT</th>
                            <th class="text-right">QUANTITY</th>
                            <th class="text-right">PRICE</th>
                            <th class="text-right">TOTAL AMOUNT</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${cartItemList}" var="cartItem">
                        <tr>
                            <td class="no">1</td>
                            <td class="text-left">${cartItem.productName}</td>
                            <td class="unit">${cartItem.quantity}</td>
                            <td class="qty">${cartItem.price}</td>
                            <td class="total">${cartItem.price * cartItem.quantity}</td>
                        </tr>
                      </c:forEach>
                    </tbody>
                    <tfoot>
                        <tr>
                            <td colspan="2"></td>
                            <td colspan="2">SUBTOTAL</td>
                            <td>${totalAmount}</td>
                        </tr>
                        <tr>
                            <td colspan="2"></td>
                            <td colspan="2">TAX 18%</td>
                            <td>${totalAmount * 0.18}</td>
                        </tr>
                        <tr>
                            <td colspan="2"></td>
                            <td colspan="2">GRAND TOTAL</td>
                            <td>${totalAmount + (totalAmount * 0.18)}</td>
                        </tr>
                    </tfoot>
                </table>
                <div class="thanks">Thank you!</div>
                <div class="notices">
                    <div>NOTICE:</div>
                    <div class="notice">A finance charge of 1.5% will be made on unpaid balances after 30 days.</div>
                </div>
            </main>
            <footer>
                Invoice was created on a computer and is valid without the signature and seal.
            </footer>
        </div>
        <!--DO NOT DELETE THIS div. IT is responsible for showing footer always at the bottom-->
        <div></div>
    </div>
</div>


</body>
</html>