package com.ecomm.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.CategoryDAO;
import com.ecomm.dao.UserDAO;
import com.ecomm.model.UserDetail;

public class UserDAOTest {

	static UserDAO userDAO; 
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		
		userDAO=(UserDAO)context.getBean("userDAO");
	
	}
	@Ignore
	@Test
	public void registerUserTest()
	{
		UserDetail user=new UserDetail();
		user.setUsername("rohan");
		user.setAddress("ranchi");
		user.setPassword("12345");
		user.setName("nitish prasad");
		user.setEmailId("nk12334@gmail.com");
		user.setEnabled(true);
		user.setMobile("8889399111");
		user.setRole("ROLE_USER");
		assertTrue("Problem in registering the user:",userDAO.registerUser(user));

	}
	@Test
	@Ignore
	public void updateUserTest()
	{
		UserDetail user=userDAO.getUser("vinod");
		user.setAddress("new delhi borewalli");
		assertTrue("Problem in updatingthe user:",userDAO.updateUserDetail(user));

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
