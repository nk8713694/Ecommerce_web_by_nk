package com.ecomm.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecomm.model.Cart;


@Repository("cartDAO")
@Transactional
public class CartDAOImpl  implements CartDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	
	@Override
	public boolean addToCart(Cart cart) {
		
		try
		{
		sessionFactory.getCurrentSession().save(cart);
		return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}

	@Override
	public boolean deleteItemFromCart(Cart cart) {
		try
		{
		sessionFactory.getCurrentSession().delete(cart);
		return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}

	@Override
	public boolean updateCartItem(Cart cart) {
		try
		{
		sessionFactory.getCurrentSession().update(cart);
		return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}

	@Override
	public Cart getCartItem(int cartId) {
	
		Session session =sessionFactory.openSession();
		Cart cart=session.get(Cart.class, cartId);
		session.close();
		return cart;
	}

	@Override
	public List<Cart> listCartItems(String username) {
		Session session =sessionFactory.openSession();
		Query query=session.createQuery("from Cart where username=:uname");
	    query.setParameter("uname", username);
	    List<Cart> cartItemList=query.list();
	    session.close();
	    return cartItemList;
	    
	
	
	}

}
