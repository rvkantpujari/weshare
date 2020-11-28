package com.weshare.service;

import java.util.List;

import com.weshare.model.Category;

public interface CategoryService {

	public void saveCategory(Category c);
	
	public List<Category> getAllCategories();
	
	public Category getCategoryById(int id);
	
	public Category getCategoryByName(String categoryName);
	
//	public List<Community> findByCategory(String categoryName);
}
