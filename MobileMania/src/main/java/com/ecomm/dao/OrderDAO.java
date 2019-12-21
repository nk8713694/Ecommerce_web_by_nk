package com.ecomm.dao;

import com.ecomm.model.OrderDetail;

public interface OrderDAO 
{
	public boolean payment(OrderDetail orderDetail);
	public boolean updateCartItemStatus(String username,int orderId);
}