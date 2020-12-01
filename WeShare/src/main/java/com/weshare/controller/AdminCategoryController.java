package com.weshare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.weshare.model.Category;
import com.weshare.service.CategoryService;

@Controller
@RequestMapping("/admin/category")
public class AdminCategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/all")
	public String categoryList(Model m)
	{
		List<Category> categoryList = categoryService.getAllCategories();
		m.addAttribute("catList", categoryList);
		return "admin/categoryList";
	}
	
	@GetMapping("/insert")
	public String insertCategory(Model m)
	{
		Category c=new Category();
		m.addAttribute("category", c);
		return "admin/insertCategory";
	}
	
	@PostMapping("/save")
	public String saveCategory(@ModelAttribute("category")Category c)
	{
		categoryService.saveCategory(c);
		return "redirect:/admin/category/all";
	}
	
	
	@GetMapping("/update/{id}")
	public String updateCategory(@PathVariable("id")int cid, Model m)
	{
		Category c=categoryService.getCategoryById(cid);
		m.addAttribute("category", c);
		return "admin/updateCategory";
	}
	
}
