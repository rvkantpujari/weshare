package com.weshare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.weshare.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {

	Category findByCategoryName(String categoryName);
	
}
