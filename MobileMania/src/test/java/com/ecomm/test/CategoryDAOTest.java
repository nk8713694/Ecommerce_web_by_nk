package com.ecomm.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.CategoryDAO;
import com.ecomm.model.Category;

public class CategoryDAOTest 
{
	static CategoryDAO categoryDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		
		categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
	}
	
	@Ignore
	@Test
	public void addCategoryTest()
	{
		Category category=new Category();
		
		category.setCategoryName("Xaomi a1");
		category.setCategoryDesc("All Mobiles of MI Brand");
		
		assertTrue("Problem in Adding Category:",categoryDAO.addCategory(category));
	}
	@Ignore
	@Test
	public void deleteCategoryTest()
	{
		Category category = categoryDAO.getCategory(2);
		assertTrue("Problem in Deleting the Category",categoryDAO.deleteCategory(category));
	}
	@Ignore
	@Test
	public void updateCategoryTest()
	{
		Category category=categoryDAO.getCategory(3);
		category.setCategoryDesc("All the Basic and Advanced Model of Xiomi");
		
		assertTrue("Problem in Updating the Category",categoryDAO.updateCategory(category));	
	}
	@Ignore
	@Test
	public void listCategoriesTest()
	{
		List<Category> categoryList=categoryDAO.listCategories();
		
		assertTrue("Problem in Listing the Categories",categoryList.size()>0);
		
		for(Category category:categoryList)
		{
			System.out.print(category.getCategoryId()+":::");
			System.out.print(category.getCategoryName()+":::");
			System.out.println(category.getCategoryDesc());
		}
	}
}
