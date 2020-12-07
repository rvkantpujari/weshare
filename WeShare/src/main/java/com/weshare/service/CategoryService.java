package com.weshare.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.weshare.model.Category;
@Service
public interface CategoryService {

	public void saveCategory(Category c);
	
	public List<Category> getAllCategories();
	
	public Category getCategoryById(int id);
	
	public Category getCategoryByName(String categoryName);
	
}
