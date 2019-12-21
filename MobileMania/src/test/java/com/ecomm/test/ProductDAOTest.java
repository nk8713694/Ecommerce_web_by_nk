package com.ecomm.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.CategoryDAO;
import com.ecomm.dao.ProductDAO;
import com.ecomm.model.Product;

public class ProductDAOTest {

	static ProductDAO productDAO;
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		
		productDAO=(ProductDAO)context.getBean("productDAO");
	}
	@Ignore
	@Test
	public void addProductTest()
	{
		Product product=new Product();
		product.setProductName("Mi 50");
		product.setProductDesc("mobile with 4g and advance feature");
		product.setPrice(18000);
		product.setStock(31);
		product.setCategoryId(34);
		product.setSupplierId(2);
		assertTrue("problem in adding the product",productDAO.addProduct(product));
		
		
		
		
	}
}
