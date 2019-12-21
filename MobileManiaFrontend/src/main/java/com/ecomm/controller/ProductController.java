package com.ecomm.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ecomm.dao.CategoryDAO;
import com.ecomm.dao.ProductDAO;
import com.ecomm.model.Category;
import com.ecomm.model.Product;

@Controller
public class ProductController 
{
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@RequestMapping("/product")
	public String showProductPage(Model m)
	{
		Product product=new Product();
		m.addAttribute("product", product);
		
		List<Product> productList=productDAO.productList();
		m.addAttribute("productList", productList);
		
		List<Category> categoryList=categoryDAO.listCategories();
		m.addAttribute("categoryList", this.getCategoryList(categoryList));
		
		return "Product";
	}
	
	public LinkedHashMap<Integer,String> getCategoryList(List<Category> categoryList)
	{
		LinkedHashMap<Integer,String> categoryMapList=new LinkedHashMap<Integer,String>();
		
		int i=0;
		
		while(i<categoryList.size())
		{
			Category category=categoryList.get(i);
			categoryMapList.put(category.getCategoryId(),category.getCategoryName());
			i++;
		}
		
		return categoryMapList;
	}

	@RequestMapping(value="/insertProduct",method=RequestMethod.POST)
	public String insertProduct(@ModelAttribute("product")Product product,Model m,@RequestParam("pimage")MultipartFile pimage)
	{
		
		productDAO.addProduct(product);
		
		
		String path="G:\\niit project\\MobileManiaFrontend\\src\\main\\webapp\\resources\\images\\";
		path=path+product.getProductId()+".jpg";
		
		File productImage=new File(path);
		
		if(!pimage.isEmpty())
		{
			try
			{
				byte[] buffer=pimage.getBytes();
				FileOutputStream fos=new FileOutputStream(productImage);
				BufferedOutputStream bs=new BufferedOutputStream(fos);
				bs.write(buffer);
				bs.close();

			}
			catch(Exception e)
			{
				System.out.println("Exception Arised:"+e);
			}
		}
		else
		{
			System.out.println("Error Occured:");
		}
		
		List<Product> productList=productDAO.productList();
		m.addAttribute("productList", productList);
		
		Product product1=new Product();
		m.addAttribute("product", product1);
		
		List<Category> categoryList=categoryDAO.listCategories();
		m.addAttribute("categoryList", this.getCategoryList(categoryList));
		
		return "Product";
	}
	
	@RequestMapping(value="/deleteProduct/{productId}")
	public String deleteProduct(@PathVariable("productId")int productId,Model m)
	{
		Product product=productDAO.getProduct(productId);
		productDAO.deleteProduct(product);
		
		List<Product> productList=productDAO.productList();
		m.addAttribute("productList", productList);
		
		Product product1=new Product();
		m.addAttribute("product", product1);
		
		List<Category> categoryList=categoryDAO.listCategories();
		m.addAttribute("categoryList", this.getCategoryList(categoryList));
		
		return "Product";
	}
	
	@RequestMapping(value="/editProduct/{productId}")
	public String editProduct(@PathVariable("productId")int productId,Model m)
	{
		Product product=productDAO.getProduct(productId);
		
		List<Product> productList=productDAO.productList();
		m.addAttribute("productList", productList);
		
		m.addAttribute("product", product);
		
		List<Category> categoryList=categoryDAO.listCategories();
		m.addAttribute("categoryList", this.getCategoryList(categoryList));
		
		return "Product";
	}
	@RequestMapping(value="/productHome")
	public String showProductHome(Model m)
	{
		List<Product> productList=productDAO.productList();
		m.addAttribute("productList", productList);
				
		List<Category> categoryList=categoryDAO.listCategories();
		m.addAttribute("categoryList", this.getCategoryList(categoryList));
		
		return "ProductHome";
	}
	@RequestMapping(value="/totalProductDisplay/{productId}")
	public String totalProductDisplay(@PathVariable("productId")int productId,Model m)
	{
		Product product=productDAO.getProduct(productId);
		m.addAttribute("product", product);
		return "TotalProductDisplay";
	}
}
