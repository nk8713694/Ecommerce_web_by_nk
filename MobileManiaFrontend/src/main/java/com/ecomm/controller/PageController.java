package com.ecomm.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController 
{
	@RequestMapping(value="/aboutUs")
	public String showAboutUsPage()
	{
		return "AboutUs";
	}
	@RequestMapping(value="/contactUs")
	public String showContactUsPage()
	{
		return "ContactUs";
	}
	@RequestMapping(value="/login")
	public String showLoginPage()
	{
		return "Login";
	}
	@RequestMapping(value="/register")
	public String showRegisterPage()
	{
		return "Register";
	}
	@RequestMapping(value="/home")
	public String showPagee()
	{
		return "home";
	}
}