package com.ecomm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecomm.dao.CategoryDAO;
import com.ecomm.model.Category;

@Controller
public class CategoryController 
{
	@Autowired
	CategoryDAO categoryDAO;

	@RequestMapping("/category")
	public String showCategoryPage(Model m)
	{
		List<Category> categoryList=categoryDAO.listCategories();
		m.addAttribute("categoryList", categoryList);
		return "Category";
	}
	
	@RequestMapping(value="/InsertCategory",method=RequestMethod.POST)
	public String insertCategory(@RequestParam("catName")String categoryName,@RequestParam("catDesc")String categoryDesc,Model m)
	{
		Category category=new Category();
		category.setCategoryName(categoryName);
		category.setCategoryDesc(categoryDesc);
		
		categoryDAO.addCategory(category);
		
		List<Category> categoryList=categoryDAO.listCategories();
		m.addAttribute("categoryList", categoryList);
		
		return "Category";
	}
	
	@RequestMapping(value="/UpdateCategory",method=RequestMethod.POST)
	public String updateCategory(@RequestParam("catId")int categoryId,@RequestParam("catName")String categoryName,@RequestParam("catDesc")String categoryDesc,Model m)
	{
		Category category=categoryDAO.getCategory(categoryId);
		
		category.setCategoryName(categoryName);
		category.setCategoryDesc(categoryDesc);
		
		categoryDAO.updateCategory(category);
		
		List<Category> categoryList=categoryDAO.listCategories();
		m.addAttribute("categoryList", categoryList);
		
		return "Category";
	}
	
	@RequestMapping("/deleteCategory/{categoryId}")
	public String deleteCategory(@PathVariable("categoryId")int categoryId,Model m)
	{
		Category category=categoryDAO.getCategory(categoryId);
		categoryDAO.deleteCategory(category);
		List<Category> categoryList=categoryDAO.listCategories();
		m.addAttribute("categoryList", categoryList);
		return "Category";
	}
	
	@RequestMapping("/editCategory/{categoryId}")
	public String editCategory(@PathVariable("categoryId")int categoryId,Model m)
	{
		Category category=categoryDAO.getCategory(categoryId);
		m.addAttribute("category", category);
		return "UpdateCategory";
	}
}