package com.weshare.service;

import java.util.List;

import com.weshare.model.Category;

public interface CategoryService {

	public void saveCategory(Category c);
	
	public List<Category> getAllCategories();
	
	public Category getCategory(int id);
}
