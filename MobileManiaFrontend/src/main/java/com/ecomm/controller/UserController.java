package com.ecomm.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import com.ecomm.dao.CategoryDAO;
import com.ecomm.dao.ProductDAO;
import com.ecomm.dao.UserDAO;
import com.ecomm.model.Category;
import com.ecomm.model.Product;
import com.ecomm.model.UserDetail;

@Controller
public class UserController 
{
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	UserDAO userDAO;
	@Autowired
	CategoryDAO categoryDAO;
	
	@RequestMapping(value="/login_success")
	public String loginSuccess(HttpSession session,Model m)
	{
		String page="";

		//This boolean variable will let us know whether the user is logged in
		boolean loggedIn=false;
		
		//This object will contain the logged in user detail like username and role.
		SecurityContext sContext=SecurityContextHolder.getContext();
		Authentication authentication=sContext.getAuthentication();
		
		String username=authentication.getName();
		
		//Getting all the roles associated with the user
		Collection<GrantedAuthority> roles=(Collection<GrantedAuthority>)authentication.getAuthorities();
				
		for(GrantedAuthority role:roles)
		{
					String role_name=role.getAuthority();
					session.setAttribute("role",role_name);
					if(role_name.equals("ROLE_ADMIN"))
					{
						loggedIn=true;
						session.setAttribute("loggedIn", loggedIn);
						
						session.setAttribute("username", username);
						page="AdminHome";
					}
					else
					{
						loggedIn=true;
						session.setAttribute("loggedIn", loggedIn);
						session.setAttribute("username", username);
						List<Product> productList=productDAO.productList();
						m.addAttribute("productList", productList);
								
						List<Category> categoryList=categoryDAO.listCategories();
						m.addAttribute("categoryList",categoryList);
						page="ProductHome";
					}
		}
		
		return page;
	}
	
	@RequestMapping(value="/adduser",method=RequestMethod.POST)
	public String addOnlyUser(@RequestParam("username")String username,
			@RequestParam("name")String name,
			@RequestParam("address")String address,
			@RequestParam("emailId")String emailId,
			@RequestParam("mobile")String mobile,
			@RequestParam("password")String password,
			Model m) 
	{
		//userDAO.registerUser(user);
		
		String passwordChars =password;
        String hashed = BCrypt.hashpw(passwordChars, BCrypt.gensalt(12));
		UserDetail userDetail = new UserDetail();
		userDetail.setUsername(username);
		userDetail.setAddress(address);
		userDetail.setEmailId(emailId);
		userDetail.setEnabled(true);
		userDetail.setMobile(mobile);
		userDetail.setName(name);
		userDetail.setPassword(hashed);
		userDetail.setRole("ROLE_USER");
		
		userDAO.registerUser(userDetail);
		m.addAttribute("userDetail", userDetail);
		return "Login";	
	}
	
	
	
	
	
	@RequestMapping(value="/perform_logout")
	public String logout(HttpSession session)
	{
		session.invalidate();
		return "Login";
	}
	
	
	
	
	
	
}