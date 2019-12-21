package com.ecomm.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.CartDAO;
import com.ecomm.model.Cart;



public class CartDAOTest {

static CartDAO cartDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		
		cartDAO=(CartDAO)context.getBean("cartDAO");
	}
   @Test
   @Ignore
	public void addCartTest()
	{
		Cart cartItem=new Cart();
		
		cartItem.setProductId(6);
		
		cartItem.setPrice(13555);
		cartItem.setProductName("samsunON8");
		cartItem.setQuantity(10);
		cartItem.setStatus("NP");
		cartItem.setUsername("vishal");
		assertTrue("problem in adding to cart",cartDAO.addToCart(cartItem));
	}
   @Test
   @Ignore
   public void deleteCartItemTest()
   {
	   Cart cartItem=cartDAO.getCartItem(6);
	   assertTrue("problem in deleting the cart item",cartDAO.deleteItemFromCart(cartItem));
   }
}
