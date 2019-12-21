package com.ecomm.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecomm.dao.CartDAO;
import com.ecomm.dao.OrderDAO;
import com.ecomm.dao.ProductDAO;
import com.ecomm.dao.UserDAO;
import com.ecomm.model.Cart;
import com.ecomm.model.OrderDetail;
import com.ecomm.model.UserDetail;

@Controller
public class OrderController 
{
	@Autowired
	CartDAO cartDAO;
	
	@Autowired
	ProductDAO productDAO;
	@Autowired
	OrderDAO orderDAO;
	
	@Autowired
	UserDAO userDAO;
	
	
	
	@RequestMapping(value="/pay",method=RequestMethod.POST)
	public String pay(@RequestParam("pmode")String pmode,HttpSession session,Model m)
	{
		String username=(String)session.getAttribute("username");
		
		List<Cart> cartItemList=cartDAO.listCartItems(username);
		m.addAttribute("cartItemList", cartItemList);
		
		int totalAmount=this.calcTotalAmount(cartItemList);
		m.addAttribute("totalAmount",totalAmount);
		
		UserDetail user=userDAO.getUser(username);
		m.addAttribute("addr", user.getAddress());
		
		OrderDetail orderDetail=new OrderDetail();
		orderDetail.setPmode(pmode);
		orderDetail.setTotalShoppingAmount(totalAmount);
		orderDetail.setUsername(username);
		orderDetail.setOrderDate(new java.util.Date());
		
		orderDAO.payment(orderDetail);
		orderDAO.updateCartItemStatus(username,orderDetail.getOrderId());
		
		m.addAttribute("orderInfo", orderDetail);
		
		return "Receipt";
	}
	
	
	@RequestMapping(value="/orderConfirm")
	public String showOrderConfirm(Model m,HttpSession session)
	{
		
		String username=(String)session.getAttribute("username");
		
		List<Cart> cartItemList=cartDAO.listCartItems(username);
		m.addAttribute("cartItemList", cartItemList);
		
		int totalAmount=this.calcTotalAmount(cartItemList);
		m.addAttribute("totalAmount",totalAmount);
		
		UserDetail user=userDAO.getUser(username);
		m.addAttribute("addr", user.getAddress());
		
		return "OrderConfirm";
	}
	
	@RequestMapping(value="/paymentPage")
	public String showPaymentPage(Model m,HttpSession session)
	{
		String username=(String)session.getAttribute("username");
		List<Cart> cartItemList=cartDAO.listCartItems(username);
		int totalAmount=this.calcTotalAmount(cartItemList);
		m.addAttribute("totalAmount",totalAmount);
		
		return "Payment";
		
	}
	
	@RequestMapping(value="/updateAddress",method=RequestMethod.POST)
	public String updateAddress(@RequestParam("address")String address,Model m,HttpSession session)
	{
		String username=(String)session.getAttribute("username");
		
		List<Cart> cartItemList=cartDAO.listCartItems(username);
		m.addAttribute("cartItemList", cartItemList);
		
		int totalAmount=this.calcTotalAmount(cartItemList);
		m.addAttribute("totalAmount",totalAmount);
		
		UserDetail user=userDAO.getUser(username);
		user.setAddress(address);
		
		userDAO.updateUserDetail(user);
		
		m.addAttribute("addr", user.getAddress());
		
		return "OrderConfirm";
	}
	
	public int calcTotalAmount(List<Cart> cartItemList)
	{
		int totalAmount=0;
		int i=0;
		while(i<cartItemList.size())
		{
			Cart cart=cartItemList.get(i);
			totalAmount=totalAmount+(cart.getPrice()*cart.getQuantity());
			i++;
		}	
		return totalAmount;
	}
	
}