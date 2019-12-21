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
import com.ecomm.dao.ProductDAO;
import com.ecomm.model.Cart;
import com.ecomm.model.Product;

@Controller
public class CartController 
{

	@Autowired
	CartDAO cartDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping(value="/cart")
	public String showCartPage(Model m,HttpSession session)
	{
		String username=(String)session.getAttribute("username");
		
		List<Cart> cartItemList=cartDAO.listCartItems(username);
		m.addAttribute("cartItemList", cartItemList);
		
		int totalAmount=this.calcTotalAmount(cartItemList);
		m.addAttribute("totalAmount",totalAmount);
		
		return "Cart";
	}
	
	@RequestMapping(value="/addToCart/{productId}")
	public String addToCart(@PathVariable("productId")int productId,@RequestParam("quantity")int quantity,Model m,HttpSession session)
	{
		
		Product product=productDAO.getProduct(productId);
		String username=(String)session.getAttribute("username");
		Cart cartItem=new Cart();
		
		cartItem.setProductId(productId);
		cartItem.setProductName(product.getProductName());
		cartItem.setPrice(product.getPrice());
		cartItem.setQuantity(quantity);
		cartItem.setStatus("NP");
		cartItem.setUsername(username);
		
		cartDAO.addToCart(cartItem);
		
		List<Cart> cartItemList=cartDAO.listCartItems(username);
		m.addAttribute("cartItemList", cartItemList);
		
		int totalAmount=this.calcTotalAmount(cartItemList);
		m.addAttribute("totalAmount",totalAmount);
		
		return "Cart";
	}
	
	@RequestMapping(value="/deleteCartItem/{cartItemId}")
	public String deleteCartItem(@PathVariable("cartItemId")int cartItemId,Model m,HttpSession session)
	{
		Cart cartItem=cartDAO.getCartItem(cartItemId);
		String username=(String)session.getAttribute("username");
		
		cartDAO.deleteItemFromCart(cartItem);
		
		List<Cart> cartItemList=cartDAO.listCartItems(username);
		m.addAttribute("cartItemList", cartItemList);
		
		int totalAmount=this.calcTotalAmount(cartItemList);
		m.addAttribute("totalAmount",totalAmount);
		
		return "Cart";
	}
	
	@RequestMapping(value="/updateCartItem/{cartItemId}",method=RequestMethod.POST)
	public String updateCartItem(@PathVariable("cartItemId")int cartItemId,Model m,HttpSession session,@RequestParam("quantity")int quantity)
	{
		Cart cartItem=cartDAO.getCartItem(cartItemId);
		String username=(String)session.getAttribute("username");
		
		cartItem.setQuantity(quantity);
		cartDAO.updateCartItem(cartItem);
		
		List<Cart> cartItemList=cartDAO.listCartItems(username);
		m.addAttribute("cartItemList", cartItemList);
		
		int totalAmount=this.calcTotalAmount(cartItemList);
		m.addAttribute("totalAmount",totalAmount);
		
		return "Cart";
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