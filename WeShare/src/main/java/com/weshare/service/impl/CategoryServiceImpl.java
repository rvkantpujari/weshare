package com.weshare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weshare.model.Category;
import com.weshare.repository.CategoryRepository;
import com.weshare.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public void saveCategory(Category c) {
		categoryRepository.save(c);
	}

	@Override
	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}
	
	@Override
	public Category getCategoryById(int id) {
		return categoryRepository.findById(id).get();
	}

	@Override
	public Category getCategoryByName(String categoryName) {
		  return categoryRepository.findByCategoryName(categoryName);
	}


}
